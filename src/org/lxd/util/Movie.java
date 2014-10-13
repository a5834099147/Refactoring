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

import org.lxd.util.price.ChildrensPrice;
import org.lxd.util.price.NewReleasePrice;
import org.lxd.util.price.Price;
import org.lxd.util.price.RegularPrice;

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
	private Price _price;
	
	public Movie(String title, int priceCode) {
		_title = title;
		///< 确保任何时刻通过取值函数与设值函数访问类型代码
		setPriceCode(priceCode);
	}

	public int getPriceCode() {
		return _price.getPriceCode();
	}

	public void setPriceCode(int _priceCode) {
		switch(_priceCode) {
		case REGULAR: 
			_price = new RegularPrice();
			break;
		case CHILDRENS:
			_price = new ChildrensPrice();
			break;
		case NEW_RELEASE:
			_price = new NewReleasePrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price Code");
		}
	}

	public String getTitle() {
		return _title;
	}	
	
	public int getFrequentRenterPoints(int daysRented) {		
		return _price.getFrequentRenterPoints(daysRented);
	}
	
	public double getCharge(int daysRented) {
		return _price.getCharge(daysRented);
	}
}
