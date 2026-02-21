package com.he1se1.ae2search.mixin;

import java.util.Locale;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Overwrite;
import appeng.api.stacks.AEKey;
import appeng.menu.me.common.GridInventoryEntry;

@Mixin(targets = "appeng.client.gui.me.search.NameSearchPredicate", remap = false)
public class MixinNameSearchPredicate {

    @Shadow
    private String term;

    @Overwrite
    public boolean test(GridInventoryEntry entry) {
        AEKey what = entry.getWhat();
        if (what == null) return false;

        String displayName = what.getDisplayName().getString().toLowerCase(Locale.ROOT);
        if (displayName.contains(this.term)) {
            return true;
        }

        String id = what.getId().toString().toLowerCase(Locale.ROOT);
        return id.contains(this.term);
    }
}