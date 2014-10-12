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
 * 租凭
 * @author: a5834099147
 * @mailto: a5834099147@126.com
 * @date: 2014年10月12日
 * @blog : http://a5834099147.github.io/
 * @review 
 */
public class Rental {
	private Movie _movie;
	private int _daysRented;
	
	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}
	
	public int getDaysRentded() {
		return _daysRented;
	}
	
	public Movie getMovie() {
		return _movie;
	}
	
	public double getCharge() {
		double result = 0;	
		
		switch (getMovie().getPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if (getDaysRentded() > 2) {
				result += (getDaysRentded() - 2) * 1.5;
			}
			break;
			
		case Movie.NEW_RELEASE:
			result += getDaysRentded() * 3;
			break;
			
		case Movie.CHILDRENS:
			result += 1.5;
			if (getDaysRentded() > 3) {
				result += (getDaysRentded() - 3) * 1.5;
			}
			break;				
		}
		
		return result;
	}
}
