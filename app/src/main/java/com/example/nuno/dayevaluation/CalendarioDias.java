package com.example.nuno.dayevaluation;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stacktips.view.CustomCalendarView;
import com.stacktips.view.DayDecorator;
import com.stacktips.view.DayView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by Nuno on 13-Mar-17.
 */

public class CalendarioDias extends Fragment {

    private CustomCalendarView calendarView;
    private String testedays;
    private Calendar currentCalendar;
    private int daysInMonth;
    private int[] teste = {0,-1,-1,
            0,1,1,
            1,1,-1,
            0,1,1,
            1,1,0,
            1,-1,0,
            1,-1,0,
            -1,1,0,
            -1,1,0,
            1,-1,0,-1,0};
    private int mesInt = 0;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.calendario_meses, container, false);

        mesInt = ((MainActivity)getActivity()).getPosition();

        //Initialize CustomCalendarView from layout
        calendarView = (CustomCalendarView) v.findViewById(R.id.calendar_view);

        currentCalendar = inflateMesCerto(mesInt);
        daysInMonth = currentCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        //Show monday as first date of week
        calendarView.setFirstDayOfWeek(Calendar.MONDAY);

        //Show/hide overflow days of a month
        calendarView.setShowOverflowDate(false);

        //call refreshCalendar to update calendar the view
        calendarView.refreshCalendar(currentCalendar);

        List<DayDecorator> decorators = new ArrayList<>();
        decorators.add(new pintaDias());
        calendarView.setDecorators(decorators);
        calendarView.refreshCalendar(currentCalendar);

        return v;
    }

    private class pintaDias implements DayDecorator {
        @Override
        public void decorate(DayView dayView) {

            final SimpleDateFormat df = new SimpleDateFormat("d");
            String date = df.format(dayView.getDate());
            int dia = Integer.parseInt(date);

            if(teste[dia-1] == -1){
                int color = Color.parseColor("RED");
                dayView.setBackgroundColor(color);
            }
            else if(teste[dia-1] == 0){
                int color = Color.parseColor("YELLOW");
                dayView.setBackgroundColor(color);
            }
            else if(teste[dia-1] == 1){
                int color = Color.parseColor("GREEN");
                dayView.setBackgroundColor(color);
            }
        }
    }

    private Calendar inflateMesCerto(int mesInt){

        switch (mesInt){
            case 0:
                currentCalendar = new GregorianCalendar(2017, Calendar.JANUARY, 1);
                break;
            case 1:
                currentCalendar = new GregorianCalendar(2017, Calendar.FEBRUARY, 1);
                break;
            case 2:
                currentCalendar = new GregorianCalendar(2017, Calendar.MARCH, 1);
                break;
            case 3:
                currentCalendar = new GregorianCalendar(2017, Calendar.APRIL, 1);
                break;
            case 4:
                currentCalendar = new GregorianCalendar(2017, Calendar.MAY, 1);
                break;
            case 5:
                currentCalendar = new GregorianCalendar(2017, Calendar.JUNE, 1);
                break;
            case 6:
                currentCalendar = new GregorianCalendar(2017, Calendar.JULY, 1);
                break;
            case 7:
                currentCalendar = new GregorianCalendar(2017, Calendar.AUGUST, 1);
                break;
            case 8:
                currentCalendar = new GregorianCalendar(2017, Calendar.SEPTEMBER, 1);
                break;
            case 9:
                currentCalendar = new GregorianCalendar(2017, Calendar.OCTOBER, 1);
                break;
            case 10:
                currentCalendar = new GregorianCalendar(2017, Calendar.NOVEMBER, 1);
                break;
            case 11:
                currentCalendar = new GregorianCalendar(2017, Calendar.DECEMBER, 1);
                break;
            default:
                currentCalendar = Calendar.getInstance(Locale.getDefault());
        }
        return currentCalendar;
    }
}
