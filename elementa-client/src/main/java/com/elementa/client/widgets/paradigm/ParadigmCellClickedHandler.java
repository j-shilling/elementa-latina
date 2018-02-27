package com.elementa.client.widgets.paradigm;

import com.elementa.shared.dto.WordDto;

public interface ParadigmCellClickedHandler {
	/**
	 * A cell has been click; handle that event.
	 * 
	 * @param words		The words displayed in the clicked cell
	 */
	public void onCellClicked (WordDto...words);
}
