package Selenium;

public class StaleElementExceptionConcept {

	public static void main(String[] args) {
		

	}

}


//Why we get stale element exception?
/*  Some components in the webpage are AJAX components (Asynchronous Java Scripts). These components can be refreshed without 
refreshing the complete page. These work on dynamic ids and they keep on changing regularly. So the find element function 
will give Stale Element Exception. That element is still available in the page just the id got changed dynamically.
*/