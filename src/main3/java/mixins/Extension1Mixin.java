package mixins;

import dependentextension.DependentExtension;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DependentExtension.class)
public class Extension1Mixin {

    @Inject(at = @At("HEAD"), method = "initialize", require = 1)
    public void preInit(CallbackInfo info) {
        System.out.println("[Extension1] Injected code via a Mixin!!!");
    }
}
