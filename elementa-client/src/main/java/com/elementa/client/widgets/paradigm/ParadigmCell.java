package com.elementa.client.widgets.paradigm;

import java.util.Collection;

import com.elementa.shared.dto.WordDto;
import com.elementa.shared.dto.form.FormDto;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

class ParadigmCell extends Composite {
	
	private static ParadigmCellUiBinder uiBinder = GWT.create(ParadigmCellUiBinder.class);

	interface ParadigmCellUiBinder extends UiBinder<Widget, ParadigmCell> {
	}
	
	@UiField
	Label label;
	
	private final ParadigmCellClickedHandler handler;
	private final WordDto[] words;
	private final FormDto form;
	
	protected ParadigmCell (ParadigmCellClickedHandler handler, FormDto form, WordDto...words) {
		this.initWidget(uiBinder.createAndBindUi(this));
		
		this.handler = handler;
		this.words = words;
		this.form = form;
		
		StringBuilder sb = new StringBuilder();
		
		if (words.length > 0)
			sb.append(this.words[0].getText());
		else
			sb.append("----------");
		
		for (int i = 1; i < this.words.length; i ++) {
			sb.append(" / " + this.words[i].getText());
		}
		
		this.label.setText(sb.toString());
		this.label.setTitle(form.toString());
		
		this.label.addClickHandler(event -> {
			ParadigmCell.this.handler.onCellClicked(ParadigmCell.this.words);
		});
	}
	
	protected ParadigmCell (ParadigmCellClickedHandler handler, FormDto form, Collection<WordDto> words) {
		this (handler, form, words.toArray(new WordDto[0]));
	}
	
	protected ParadigmCell addWord (WordDto word) {
		WordDto[] words = new WordDto[this.words.length + 1];
		words[words.length - 1] = word;
		
		return new ParadigmCell (this.handler, form, words);
	}

}
