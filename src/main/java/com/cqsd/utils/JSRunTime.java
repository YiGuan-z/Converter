package com.cqsd.utils;


public abstract class JSRunTime<T> implements Runnable {
	protected abstract T run(String script, String func, Object... args);

	private String script;
	private String func;
	private Object[] args;
	public T result;

	@Override
	public void run() {
		if (!script.isEmpty()) {
			result = run(script, func, args);
		} else {
			throw new RuntimeException("script not found");
		}
	}
}
