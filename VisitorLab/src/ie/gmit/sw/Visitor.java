package ie.gmit.sw;

import java.util.function.Function;

public class Visitor<T> {
	private Function<T, T> command;

	public Visitor() {
		this.command = Function.identity();
	}

	public void setCommand(Function<T, T> command) {
		this.command = command;
	}

	public void visit(Visitable<T> e) {
		e.setValue(command.apply(e.getValue()));
	}
}