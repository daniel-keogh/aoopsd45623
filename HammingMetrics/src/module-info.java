module gmit.character.metrics {
	requires gmit.character.service;
	
	exports ie.gmit.sw.hamming;
	
	provides ie.gmit.character.Measurable with ie.gmit.sw.hamming.HammingImpl;
}