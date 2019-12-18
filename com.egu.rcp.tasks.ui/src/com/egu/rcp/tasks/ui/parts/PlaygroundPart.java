package com.egu.rcp.tasks.ui.parts;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Text;

/**
 * Playground用のパーツです。
 * @author t-eguchi
 *
 */
public class PlaygroundPart {

	/** テキスト */
	private Text text;

	/** ボタン */
	private Button button;

	/** ブラウザ */
	private Browser browser;

	/**
	 * コントロールを構成します。
	 * @param parent
	 */
	@PostConstruct
	public void buildControls(Composite parent) {
		// レイアウト
		Layout layout = new GridLayout(2, false);
		parent.setLayout(layout);

		// テキストの作成
		text = new Text(parent, SWT.BORDER);
		text.setMessage("Enter City");
		GridData textData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		text.setLayoutData(textData);

		// ブラウザの作成
		browser = new Browser(parent, SWT.NONE);
		GridData browserData = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		browser.setLayoutData(browserData);

		// ボタンの作成
		button = new Button(parent, SWT.PUSH);
		button.setText("Search");
		SelectionListener searchListener = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				// テキストの取得
				String cityName = text.getText();
				if (cityName.isEmpty()) {
					return;
				}

				// ブラウザの表示
				try {
					browser.setUrl("https://www.google.com/maps/place/"
					        + URLEncoder.encode(cityName, "UTF-8")
					        + "/&output=embed");
				} catch (UnsupportedEncodingException e) {
					throw new RuntimeException(e);
				}
			}
		};
		button.addSelectionListener(searchListener);
	}

	@Focus
	public void onFocus() {
		text.setFocus();
	}
}
