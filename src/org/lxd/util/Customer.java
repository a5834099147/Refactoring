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

import java.util.Enumeration;
import java.util.Vector;

/**
 * 顾客
 * @author: a5834099147
 * @mailto: a5834099147@126.com
 * @date: 2014年10月12日
 * @blog : http://a5834099147.github.io/
 * @review 
 */
public class Customer {
	private String _name;
	private Vector<Rental> _rentals = new Vector<>();
	
	public Customer (String name) {
		_name = name;
	}
	
	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}
	
	public String getName() {
		return _name;
	}
	
	///< 生成详单
	public String statement()
	{
		double totalAmount = 0;		
		int frequentRenterPoints = 0;
		
		Enumeration< Rental> rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		
		while (rentals.hasMoreElements()) {
			Rental each = rentals.nextElement();		
			frequentRenterPoints += each.getFrequentRenterPoints();			
			
			///< show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
			totalAmount += each.getCharge();
		}
		
		///< add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequest renter points";
		return result;
	}		
}
