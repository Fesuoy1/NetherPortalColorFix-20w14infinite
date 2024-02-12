package org.mod.portal_updater.mixins;

import net.minecraft.block.BlockState;
import net.minecraft.block.NeitherPortalBlock;
import net.minecraft.block.NetherPortalBlock;
import net.minecraft.block.PortalBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.NetherPortalBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(PortalBlock.class)
public class PortalBlockMixin {

    @Inject(method = "onEntityCollision", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;remove()V", shift = At.Shift.BEFORE))
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, CallbackInfo ci) {
        PortalBlock portalBlock = (PortalBlock) (Object) this;
        BlockEntity blockEntity = world.getBlockEntity(pos);

        if ((portalBlock instanceof NeitherPortalBlock || portalBlock instanceof NetherPortalBlock) && blockEntity instanceof NetherPortalBlockEntity) {
            blockEntity.markDirty();
            world.updateListeners(pos, state, state, 3);
        }
    }
}
