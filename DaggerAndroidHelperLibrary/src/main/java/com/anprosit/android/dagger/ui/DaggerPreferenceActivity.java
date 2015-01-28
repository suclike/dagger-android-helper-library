package com.anprosit.android.dagger.ui;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.anprosit.android.dagger.DaggerContext;
import com.anprosit.android.dagger.helper.DaggerHelper;

import java.util.List;

import dagger.ObjectGraph;

/**
 * @author KeithYokoma
 */
public abstract class DaggerPreferenceActivity extends PreferenceActivity implements DaggerContext {
	private DaggerHelper mHelper = new DaggerHelper();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		mHelper.onCreate(this, getModules());
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onDestroy() {
		mHelper.onDestroy();
		super.onDestroy();
	}

	protected abstract List<Object> getModules();

	@Override
	public <T> T inject(T obj) {
		return mHelper.inject(obj);
	}

	@Override
	public ObjectGraph getObjectGraph() {
		return mHelper.getObjectGraph();
	}
}