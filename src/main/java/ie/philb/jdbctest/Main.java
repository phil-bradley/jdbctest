package ie.philb.jdbctest;

public class Main {

	public static void main(String[] args) {
		
		if (args.length !=3) {
			usage();
			return;
		}
		
		String login = args[0];
		String password = args[1];
		String url = args[2];
		
		JdbcTester jdbcTester = new JdbcTester(login, password, url);
		jdbcTester.runTestQuery();
		
	}
	
	private static void usage() {
		System.err.println("Usage: Main <login> <password> <url>");
	}
}
