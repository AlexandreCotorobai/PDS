import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Plugin {
	public static void main(String[] args) throws Exception {

		File proxyList = new File("./");
		ArrayList<IPlugin> plgs = new ArrayList<IPlugin>();
		for (String f : proxyList.list()) {
			// System.out.println("Carregando " + f);
			// if (f.endsWith(".class")) {
				try {
					plgs.add(PluginManager.load(
							f.substring(0, f.lastIndexOf('.'))));

				} catch (Exception e) {
					System.out.println("\t" + f + ": Componente ignorado. Não é IPlugin.");
				}
			// }
		}
		Iterator<IPlugin> it = plgs.iterator();
		while (it.hasNext()) {
			it.next().fazQualQuerCoisa();
		}

		// menu with show list of plugins
		// and execute the selected plugin

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\nMenu: ");
			System.out.println("1 - Show list of plugins");
			System.out.println("2 - Execute the selected plugin");

			switch (sc.nextInt()) {
			case 1:
				System.out.println("List of plugins: ");
				for (IPlugin plugin : plgs) {
					System.out.println(plugin.getClass().getName());
				}
				break;
			case 2:
				System.out.println("Select the plugin: ");
				String pluginName = sc.next();
				for (IPlugin plugin : plgs) {
					if (plugin.getClass().getName().equals(pluginName)) {
						plugin.fazQualQuerCoisa();
					}
				}
				break;
			default:
				System.out.println("Invalid option");
				break;
			}
		}
	}
}