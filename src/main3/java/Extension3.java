import dependentextension.DependentExtension;
import extension2.Extension2;
import net.minestom.server.MinecraftServer;
import net.minestom.server.command.builder.Command;
import net.minestom.server.extensions.Extension;

public class Extension3 extends Extension {

    private Command myCommand = new Command("extension3.command") {
        {
            setDefaultExecutor((source, args) -> source.sendMessage("Hello from extension3, after being reloaded! "+Extension3.class.hashCode()));
        }
    };

    @Override
    public void initialize() {
        System.out.println("[Extension3] Extension1 was initialized at (in nanoseconds): "+ DependentExtension.initializationTime);
        System.out.println("[Extension3] Extension1 has class: "+ DependentExtension.class);
        System.out.println("[Extension3] Extension1 class hashCode: "+ DependentExtension.class.hashCode());
        System.out.println("[Extension3] Extension2 has class: "+ Extension2.class);
        System.out.println("[Extension3] Extension2 class hashCode: "+ Extension2.class.hashCode());

        MinecraftServer.getCommandManager().register(myCommand);
    }

    @Override
    public void terminate() {
        System.out.println("UNLOADING COMMAND");
        MinecraftServer.getCommandManager().unregister(myCommand);
    }
}
