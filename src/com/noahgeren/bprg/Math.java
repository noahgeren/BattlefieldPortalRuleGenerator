package com.noahgeren.bprg;

public class Math {

	private Math() {
	}

	public static Value<Number> add(Value<Number> a, Value<Number> b) {
		return new Value<Number>(String.format(
				"<block type=\\\"Add\\\"><value name=\\\"VALUE-0\\\">%s</value><value name=\\\"VALUE-1\\\">%s</value></block>",
				a.toString(), b.toString()));
	}

}
