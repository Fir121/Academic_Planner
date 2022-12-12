package com.oops;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

// NOTE: Run These Tests with a Fresh Database!
public class AppTest 
{
    @Test
    public void testCourses(){ 
        // Check addCourse
        assertTrue(Courses.addCourse("JUNIT TEST", "CS F121", 4));
        assertFalse(Courses.addCourse("JUNIT TEST", "CS F121", -4));

        // Check Courses class constructor
        Courses courses = new Courses();
        assertEquals(1, courses.courses.size());
        assertEquals("JUNIT TEST", courses.courses.get(0).courseName);
        int id = courses.courses.get(0).id;
        assertEquals(courses.courses.get(0), courses.getCourse(id));

        // Check setCourse
        assertTrue(Courses.setCourse(id, "JUNIT TEST 2", "CS F121", 4));

        // Check set, get Weekly
        assertTrue(Courses.setWeekly(id, new boolean[]{false,false,false,false,true}));
        assertArrayEquals(Courses.getWeekly(id),new boolean[]{false,false,false,false,true});

        // Check remove course
        assertTrue(Courses.removeCourse(id));
        courses = new Courses();
        assertEquals(0, courses.courses.size());

        // RE ADDING COURSE TO TEST COMPONENTS
        assertTrue(Courses.addCourse("JUNIT TEST", "CS F121", 4));
        courses = new Courses();
        testComponents(courses.courses.get(0).id);
    }

    public void testComponents(int id){
        // Check addComponent
        assertTrue(Components.addComponent(id, "JUNIT COMPONENT", new Date(), 10.5));
        assertFalse(Components.addComponent(id, "JUNIT COMPONENT", new Date(), -10.5));
        assertFalse(Components.addComponent(id, "JUNIT COMPONENT", new Date(), 100.0));

        // Check Components class constructor
        Components components = new Components(id);
        assertEquals(1, components.components.size());
        assertEquals("JUNIT COMPONENT", components.components.get(0).componentName);
        int componentid = components.components.get(0).id;
        assertEquals(components.components.get(0), components.getComponent(componentid));

        // Check setComponent
        assertTrue(Components.editComponent(id, componentid, "JUNIT COMPONENT 2",new Date(), 4.0));
        assertFalse(Components.editComponent(id, componentid, "JUNIT COMPONENT 2",new Date(), 114.0));

        // Check removeComponent
        assertTrue(Components.removeComponent(componentid));
        components = new Components(id);
        assertEquals(0, components.components.size());
    }

    @Test
    public void testEvents(){

    }

    @Test
    public void testAttendance(){

    }
}
