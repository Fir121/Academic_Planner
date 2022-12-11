package com.oops;

import javax.swing.*;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.util.*;
import java.time.*;
import java.awt.event.*;

public class CalendarDatesPanel extends JPanel implements ActionListener{
    int cur_year;
    int cur_month;
    JLabel timeHeader;
    CalendarEvents events;

    ArrayList<JPanel> panels = new ArrayList<>();

    public CalendarDatesPanel(){
        LocalDate today = LocalDate.now();
        cur_year = today.getYear();
        cur_month = today.getMonthValue();

        setLayoutStyle();
        addCalendarHeader();
        renderDate();
    }
    
    private void renderDate(){
        renderDate(cur_year, cur_month);
    }
    private void renderDate(int difference){
        LocalDate dt = LocalDate.of(cur_year, cur_month, 1);
        if (difference > 0){
            dt = dt.plusMonths(1);
        }
        else{
            dt = dt.minusMonths(1);
        }
        cur_year = dt.getYear();
        cur_month = dt.getMonthValue();
        renderDate();
    }
    private void renderDate(int cur_year, int cur_month){
        events = new CalendarEvents(cur_year, cur_month);

        String[][] dateArray = get2DCalendarArray(cur_year, cur_month);

        timeHeader = new JLabel(LocalDate.of(cur_year, cur_month, 1).getMonth()+" "+cur_year);
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 3;
		gbc_lblNewLabel_8.gridy = 0;
		add(timeHeader, gbc_lblNewLabel_8);

        int day = 0;

        for (int i=0;i<dateArray.length;i++){
            for (int j=0;j<dateArray[i].length;j++){
                if (dateArray[i][j] == null){
                    continue;
                }
                day++;
                JPanel panel = new JPanel();
                panel.setBorder(new LineBorder(new Color(0, 0, 0)));
                GridBagConstraints gbc_panel = new GridBagConstraints();
                gbc_panel.insets = new Insets(0, 0, 5, 5);
                gbc_panel.fill = GridBagConstraints.BOTH;
                gbc_panel.gridx = j;
                gbc_panel.gridy = 2+i;
                add(panel, gbc_panel);

                GridBagLayout gbl_contentPane = new GridBagLayout();
                gbl_contentPane.columnWidths = new int[]{0};
                gbl_contentPane.rowHeights = new int[]{0, 0};
                gbl_contentPane.columnWeights = new double[]{1.0};
                gbl_contentPane.rowWeights = new double[]{1.0, 1.0};
                panel.setLayout(gbl_contentPane);

                JLabel lbl = new JLabel(dateArray[i][j]);
                lbl.setHorizontalAlignment(SwingConstants.CENTER);
                GridBagConstraints gbc_panel_lbl = new GridBagConstraints();
                gbc_panel_lbl.insets = new Insets(0, 0, 5, 0);
                gbc_panel_lbl.gridx = 0;
                gbc_panel_lbl.gridy = 0;
                panel.add(lbl, gbc_panel_lbl);
                Box verticalBox = Box.createVerticalBox();
                GridBagConstraints gbc_panel_vbx = new GridBagConstraints();
                gbc_panel_vbx.gridx = 0;
                gbc_panel_vbx.gridy = 1;
                panel.add(verticalBox, gbc_panel_vbx);
                

                if (events.containsDate(cur_year+"/"+cur_month+"/"+day)){
                    for (Event ex: events.getEventsOnDate(cur_year+"/"+cur_month+"/"+day)){
                        JButton event_x = new JButton();
                        event_x.setText(ex.eventName);
                        event_x.putClientProperty("eventid", ex.id);
                        event_x.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                int eventId = (Integer)((JButton)e.getSource()).getClientProperty( "eventid" );
                                Event eventDetails = events.getEvent(eventId);
                                JTextField eventName = new JTextField();
                                eventName.setText(eventDetails.eventName);
                                JComboBox<String>  eventCategory = new JComboBox<>(Constants.CATEGORIES);
                                eventCategory.setSelectedItem(eventDetails.category);
                                JDateChooser eventDate = new JDateChooser();
                                eventDate.setDate(eventDetails.date);
                                JRadioButton remind = new JRadioButton("Reminder?");
                                remind.setSelected(eventDetails.reminder);
                                Object[] message = {
                                    "Event Name:", eventName,
                                    "Event Category:", eventCategory,
                                    "Event Date:",eventDate, 
                                    remind
                                };
                
                                int option = JOptionPane.showConfirmDialog(null, message, "Edit Event", JOptionPane.OK_CANCEL_OPTION);
                                if (option == JOptionPane.OK_OPTION) {
                                    if (CalendarEvents.addEvent(eventName.getText(), String.valueOf(eventCategory.getSelectedItem()), eventDate.getDate(), remind.isSelected())){
                                        new CalendarPanel();
                                    }
                                    else{
                                        // failed
                                    }
                                }
                            }
                        });
                        verticalBox.add(event_x);
                    }
                }

                panels.add(panel);
            }
        }
        revalidate();
        repaint();
    }
    private void addCalendarHeader(){
        JButton btnNewButton = new JButton("Prev");
        btnNewButton.putClientProperty( "difference", -1);
        btnNewButton.addActionListener(this);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);
		
		JButton button = new JButton("Next");
        button.putClientProperty( "difference", 1);
        button.addActionListener(this);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 6;
		gbc_button.gridy = 0;
		add(button, gbc_button);

        JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.SOUTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		
		JLabel lblNewLabel = new JLabel("S");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.SOUTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("M");
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.SOUTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 1;
		add(panel_2, gbc_panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("T");
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.anchor = GridBagConstraints.SOUTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_3.gridx = 3;
		gbc_panel_3.gridy = 1;
		add(panel_3, gbc_panel_3);
		
		JLabel lblNewLabel_3 = new JLabel("W");
		panel_3.add(lblNewLabel_3);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.anchor = GridBagConstraints.SOUTH;
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_4.gridx = 4;
		gbc_panel_4.gridy = 1;
		add(panel_4, gbc_panel_4);
		
		JLabel lblNewLabel_4 = new JLabel("T");
		panel_4.add(lblNewLabel_4);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.anchor = GridBagConstraints.SOUTH;
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_5.gridx = 5;
		gbc_panel_5.gridy = 1;
		add(panel_5, gbc_panel_5);
		
		JLabel lblNewLabel_5 = new JLabel("F");
		panel_5.add(lblNewLabel_5);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.anchor = GridBagConstraints.SOUTH;
		gbc_panel_6.insets = new Insets(0, 0, 5, 5);
		gbc_panel_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_6.gridx = 6;
		gbc_panel_6.gridy = 1;
		add(panel_6, gbc_panel_6);
		
		JLabel lblNewLabel_6 = new JLabel("S");
		panel_6.add(lblNewLabel_6);
    }

    private String[][] get2DCalendarArray(int year, int month){
        String[][] dates = new String[6][7];

        LocalDate _today = LocalDate.of(year, month, 1);
        DayOfWeek _dayOfWeek = _today.getDayOfWeek();

        int dayOfWeek=0;
        switch((int)_dayOfWeek.getValue()){
            case 1:dayOfWeek=2;break;
            case 2:dayOfWeek=3;break;
            case 3:dayOfWeek=4;break;
            case 4:dayOfWeek=5;break;
            case 5:dayOfWeek=6;break;
            case 6:dayOfWeek=7;break;
            case 7:dayOfWeek=1;break;
        }
        int daysInMonth =  _today.lengthOfMonth();;
        
        //print initial spaces
        int i_count = 0;
        int j_count = 0;
        for (int i = 0; i < dayOfWeek-1; i++) {
            dates[j_count][i_count] = null;
            i_count++;
        }
        
        //print the days of the month starting from 1
        for (int i = 0, dayOfMonth = 1; dayOfMonth <= daysInMonth; i++) {
            for (int j = ((i == 0) ? dayOfWeek - 1 : 0); j < 7 && (dayOfMonth <= daysInMonth); j++) {
                dates[j_count][i_count] = String.format("%2d", dayOfMonth);
                i_count++;
                dayOfMonth++;
            }
            j_count++;
            i_count = 0;
        }

        return dates;
    }
    private void setLayoutStyle(){
        GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gbl_contentPane);
    }
    public void actionPerformed(ActionEvent e){
        remove(timeHeader);
        for (JPanel panel: panels){
            remove(panel);
        }
        panels = new ArrayList<>();
        renderDate((Integer)((JButton)e.getSource()).getClientProperty( "difference" ));
    }
}
