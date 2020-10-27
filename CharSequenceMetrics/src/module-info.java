module gmit.character.service {
	exports ie.gmit.character;
	
	provides ie.gmit.character.Measurable with ie.gmit.character.Levenshtein;
}