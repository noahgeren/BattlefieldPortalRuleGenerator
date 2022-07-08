package com.noahgeren.bprg;

public class Math {

	private Math() {
	}

	public static Value<Integer> add(Value<Integer> a, Value<Integer> b) {
		return new Value<Integer>(String.format(
				"<block type=\\\"Add\\\"><value name=\\\"VALUE-0\\\">%s</value><value name=\\\"VALUE-1\\\">%s</value></block>",
				a.toString(), b.toString()));
	}

}
