/*
 # Copyright (c) 2008 Laurent Morissette
 #
 # Permission is hereby granted, free of charge, to any person obtaining a copy
 # of this software and associated documentation files (the "Software"), to deal
 # in the Software without restriction, including without limitation the rights
 # to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 # copies of the Software, and to permit persons to whom the Software is
 # furnished to do so, subject to the following conditions:
 #
 # The above copyright notice and this permission notice shall be included in
 # all copies or substantial portions of the Software.
 #
 # THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 # IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 # FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 # AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 # LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 # OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 # THE SOFTWARE.
 */
package ca.uqam.inf2015.equipe2.gestionreclamation;

import java.text.ParseException;
import java.util.GregorianCalendar;

/**
 *
 * @author Laurent Morissette
 */
public class DateUtil {

    /**
     * Classe struct pourle parsing de date
     */
    public static class DateDigits {

        static int YEAR = 0;
        static int MONTH = 1;
        static int DAY = 2;
    }

    /**
     *
     * @param pdate La date au format YYY-MM--DD
     * @return une instance de Gregoriancalendar correspondant à la date fournie
     */
    public static GregorianCalendar getParsedDate(String pdate)throws ParseException{
        String[] dateElms = pdate.split("-");
        try {
            return new GregorianCalendar(Integer.parseInt(dateElms[DateDigits.YEAR]), 
                    Integer.parseInt(dateElms[DateDigits.MONTH]), 
                    Integer.parseInt(dateElms[DateDigits.DAY]));
        } catch (Exception e) {
          throw e;
        }
    }
}