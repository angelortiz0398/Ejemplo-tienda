module Ejemplo {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires java.sql;
	requires java.desktop;
	
	requires jdk.javadoc;
	requires jdk.compiler;
	requires java.xml;
	requires org.hibernate.orm.core;
	requires java.naming;
	requires java.persistence;
	requires de.jensd.fx.glyphs.fontawesome;
	requires net.bytebuddy;
	
	

	
	
	opens entidades to javafx.graphics, javafx.fxml, javafx.base;
	opens application to javafx.graphics, javafx.fxml;
	opens controladores to javafx.graphics, javafx.fxml;
	opens stylesheet to javafx.graphics, javafx.fxml;
	opens vista to javafx.graphics, javafx.fxml;
}
