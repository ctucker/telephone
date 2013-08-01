package org.telephone;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Map;

import org.junit.Test;

import com.google.common.collect.Maps;

import static org.hamcrest.Matchers.is;

public class Main {

	/*
	@Test
	public void twoNumbersAreNotConsistent() {
		String bob = "91125426";
		String emergency = "911";
		
		assertThat(NumberConsistencyChecker.isConsistent(bob, emergency), equalTo(false));
	}
	
	@Test
	public void twoNumbersAreConsistent() {
		String bob = "91125426";
		String alice = "97 625 992";
				
		assertThat(NumberConsistencyChecker.isConsistent(bob, alice), equalTo(true));
	}
	*/
	
	public Phonebook getPhonebookSample() {
		Map<String, String> entries = Maps.newHashMap();
		entries.put("bob", "91125426");
		entries.put("emergency", "911");
		entries.put("alice", "97 625 992");
		return new Phonebook(entries);
	}
	
	@Test
	public void anEmptyPhonebookIsConsistent() {
		assertThat(new Phonebook().isConsistent(), is(true));
	}
	
	@Test
	public void aSingleEntryPhonebookIsConsistent() {
		assertThat(new Phonebook("jim", "33423911").isConsistent(), is(true));
	}
	
	@Test
	public void multipleConsistentEntriesAreConsistent() {
		Map<String, String> entries = Maps.newHashMap();
		entries.put("bob", "91125426");
		entries.put("jim", "34523452");
		entries.put("alice", "97 625 992");
		Phonebook sample = new Phonebook(entries);
		assertThat(sample.isConsistent(), is(true));
	}
	
	@Test
	public void twoInconsistentEntriesAreInconsistent() {
		Map<String, String> entries = Maps.newHashMap();
		entries.put("bob", "91125426");
		entries.put("emergency", "911");
		Phonebook sample = new Phonebook(entries);
		assertThat(sample.isConsistent(), is(false));
	}
	
	@Test
	public void twoInconsistentEntriesWithSpaceAreInconsistent() {
		Map<String, String> entries = Maps.newHashMap();
		entries.put("bob", "91 125426");
		entries.put("emergency", "911");
		Phonebook sample = new Phonebook(entries);
		assertThat(sample.isConsistent(), is(false));
	}
	
	
		
}
