package ie.gmit.sw;

public class ComStoredSequenceListAdapter implements SequenceListStore {
	private StoredSequenceContext ctx; 
	
	public ComStoredSequenceListAdapter(CharSequence s) {
		super();
		this.ctx = new StoredSequenceContext(s); 
	}

	@Override
	public void open(CharSequence fileName) throws Exception {
		ctx.open(fileName);
	}

	@Override
	public void store(CharSequence[] list) throws Exception {
		for (CharSequence cs : list) {
			if (ctx.compare(cs, false, false) > 0) {
				ctx.store(cs);
			}
		}
	}

	@Override
	public void close() throws Exception {
		ctx.close();
	}
}
