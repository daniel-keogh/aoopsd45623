module gmit.software {
	requires java.desktop;
	
	requires javafx.base;
	requires javafx.graphics;
	requires transitive javafx.controls;
	
	exports ie.gmit.sw;
}