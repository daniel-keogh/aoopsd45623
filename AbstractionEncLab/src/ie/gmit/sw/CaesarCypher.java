package ie.gmit.sw;

public class CaesarCypher extends AbstractCypher  {
	public byte[] doCypher(byte[] bytes, boolean encrypt) throws CypherException {
		for (int i = 0; i < bytes.length; i++) {
			int k = Integer.parseInt(super.getCypherKey().getPattern());
			
			if (encrypt) {
				bytes[i] += k;
			} else {
				bytes[i] -= k;
			}
		}
		
		return bytes;
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}
}
