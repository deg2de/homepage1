package com.leesungbok.kyoutuubuhinn;

import com.leesungbok.workbook.WorkBook;

public class Cyoutuubuhinn {

	public boolean nullCheck(String str) {
		if(str == WorkBook.STR_NULL || str == WorkBook.STR_KUUHAKU || str.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
