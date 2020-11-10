package ie.gmit.sw;

public class InhStoredSequenceListAdapter extends StoredSequenceContext implements SequenceListStore {

	public InhStoredSequenceListAdapter(CharSequence s) {
		super(s);
	}

	@Override
	public void store(CharSequence[] list) throws Exception {
		for (CharSequence cs : list) {
			if (super.compare(cs, false, false) > 0) {
				super.store(cs);
			}
		}
	}
}
