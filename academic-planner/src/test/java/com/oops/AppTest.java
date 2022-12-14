package com.oops;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

// NOTE: Run These Tests with a Fresh Database!
public class AppTest 
{
    @BeforeClass
    public static void deleteDB1(){
        File myObj = new File("database.db"); 
        myObj.delete();
    }
    @AfterClass
    public static void deleteDB2(){
        File myObj = new File("database.db"); 
        myObj.delete();
    }

    @Test
    public void testCourses(){ 
        // Check addCourse
        assertTrue(Courses.addCourse("JUNIT TEST", "CS F121", 4));
        assertFalse(Courses.addCourse("JUNIT TEST", "CS F121", -4));

        // Check Courses class constructor
        Courses courses = new Courses();
        assertEquals(1, courses.getArrayListCourses().size());
        assertEquals("JUNIT TEST", courses.getArrayListCourses().get(0).getCourseName());
        int id = courses.getArrayListCourses().get(0).getId();
        assertEquals(courses.getArrayListCourses().get(0), courses.getCourse(id));

        // Check setCourse
        assertTrue(Courses.setCourse(id, "JUNIT TEST 2", "CS F121", 4));

        // Check set, get Weekly
        assertTrue(Courses.setWeekly(id, new boolean[]{false,false,false,false,true}));
        assertArrayEquals(Courses.getWeekly(id),new boolean[]{false,false,false,false,true});

        testComponents(id);
        testAttendance(id);

        // Check remove course
        assertTrue(Courses.removeCourse(id));
        courses = new Courses();
        assertEquals(0, courses.getArrayListCourses().size());
    }

    public void testComponents(int id){
        // Check addComponent
        assertTrue(Components.addComponent(id, "JUNIT COMPONENT", new Date(), 10.5));
        assertFalse(Components.addComponent(id, "JUNIT COMPONENT", new Date(), -10.5));
        assertFalse(Components.addComponent(id, "JUNIT COMPONENT", new Date(), 100.0));

        // Check Components class constructor
        Components components = new Components(id);
        assertEquals(1, components.getArrayListComponents().size());
        assertEquals("JUNIT COMPONENT", components.getArrayListComponents().get(0).getComponentName());
        int componentid = components.getArrayListComponents().get(0).getId();
        assertEquals(components.getArrayListComponents().get(0), components.getComponent(componentid));

        // Check setComponent
        assertTrue(Components.editComponent(id, componentid, "JUNIT COMPONENT 2",new Date(), 4.0));
        assertFalse(Components.editComponent(id, componentid, "JUNIT COMPONENT 2",new Date(), 114.0));

        // Check removeComponent
        assertTrue(Components.removeComponent(componentid));
        components = new Components(id);
        assertEquals(0, components.getArrayListComponents().size());
    }

    public void testAttendance(int id){
        Attendances attendances = new Attendances();
        assertEquals(1, attendances.getArrayListAttendances().size());
    }

    @Test
    public void testEvents(){
        Date now = new Date();
        CalendarEvents.addEvent("JUNIT EVENT", "Default",now, false);

        CalendarEvents events = new CalendarEvents(DateAlternate.getYear(now), DateAlternate.getMonth(now));
        assertEquals(1, events.getArrayListEvents().size());
        assertTrue(events.containsDate(DateAlternate.getString(now)));
        assertEquals(1, events.getEventsOnDate(DateAlternate.getString(now)).size());
        int id = events.getArrayListEvents().get(0).getId();

        assertTrue(CalendarEvents.editEvent(id,"JUNIT EVENT 2","Holiday", now, false));
        assertTrue(CalendarEvents.deleteEvent(id));

        // Check remove course
        events = new CalendarEvents(DateAlternate.getYear(now), DateAlternate.getMonth(now));
        assertEquals(0, events.getArrayListEvents().size());
    }
}
