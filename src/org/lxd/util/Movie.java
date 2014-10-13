/*
 * Copyright (C) 2014 a5834099147(lxd) <a5834099147@126.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.lxd.util;

/**
 * 影片
 * @author: a5834099147
 * @mailto: a5834099147@126.com
 * @date: 2014年10月12日
 * @blog : http://a5834099147.github.io/
 * @review 
 */
public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	
	private String _title;
	private int _priceCode;
	
	public Movie(String title, int priceCode) {
		_title = title;
		_priceCode = priceCode;
	}

	public int getPriceCode() {
		return _priceCode;
	}

	public void setPriceCode(int _priceCode) {
		this._priceCode = _priceCode;
	}

	public String getTitle() {
		return _title;
	}	
	
	public double getCharge(int daysRented) {
		double result = 0;	
		
		switch (getPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if (daysRented > 2) {
				result += (daysRented - 2) * 1.5;
			}
			break;
			
		case Movie.NEW_RELEASE:
			result += daysRented * 3;
			break;
			
		case Movie.CHILDRENS:
			result += 1.5;
			if (daysRented > 3) {
				result += (daysRented - 3) * 1.5;
			}
			break;				
		}
		
		return result;
	}
}
