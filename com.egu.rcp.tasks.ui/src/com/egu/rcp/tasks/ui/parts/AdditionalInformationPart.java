package com.egu.rcp.tasks.ui.parts;

import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * 付加情報を扱うパーツです。
 * @author t-eguchi
 *
 */
public class AdditionalInformationPart {

    @PostConstruct
    public void postConstruct(Composite parent) {
        new Text(parent, SWT.BORDER | SWT.MULTI);
        AtomicLong value = new AtomicLong();
        value.incrementAndGet();
    }
}
