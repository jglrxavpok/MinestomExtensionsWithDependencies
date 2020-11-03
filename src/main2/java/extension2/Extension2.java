package extension2;

import dependentextension.DependentExtension;
import net.minestom.server.extensions.Extension;

public class Extension2 extends Extension {
    @Override
    public void initialize() {
        System.out.println("[Extension2] Extension1 was initialized at (in nanoseconds): "+ DependentExtension.initializationTime);
        System.out.println("[Extension2] Extension1 has class: "+ DependentExtension.class);
        System.out.println("[Extension2] Extension1 class hashCode: "+ DependentExtension.class.hashCode());
    }

    @Override
    public void terminate() {

    }
}
