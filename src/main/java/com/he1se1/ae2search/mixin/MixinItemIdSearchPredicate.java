package com.he1se1.ae2search.mixin;

import java.util.Objects;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Overwrite;
import appeng.api.stacks.AEKey;
import appeng.menu.me.common.GridInventoryEntry;

@Mixin(targets = "appeng.client.gui.me.search.ItemIdSearchPredicate", remap = false)
public class MixinItemIdSearchPredicate {

    @Shadow @Final private String term;

    @Overwrite
    public boolean test(GridInventoryEntry gridInventoryEntry) {
        AEKey entryInfo = Objects.requireNonNull(gridInventoryEntry.getWhat());
        String displayName = entryInfo.getDisplayName().getString();
        return displayName.toLowerCase().contains(this.term);
    }
}