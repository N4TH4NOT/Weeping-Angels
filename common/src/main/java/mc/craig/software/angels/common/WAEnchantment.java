package mc.craig.software.angels.common;

import mc.craig.software.angels.common.enchantment.QuantumBreakingEnchantment;
import mc.craig.software.angels.registry.DeferredRegistry;
import mc.craig.software.angels.registry.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.item.enchantment.Enchantment;

import static mc.craig.software.angels.WeepingAngels.MODID;

public class WAEnchantment {
    public static final DeferredRegistry<Enchantment> ENCHANTMENTS = DeferredRegistry.create(MODID, Registry.ENCHANTMENT_REGISTRY);

//    Only available on Forge ;(
//    public static final EnchantmentCategory PICKAXE = EnchantmentCategory.create("PICKAXE", item -> item instanceof PickaxeItem);
//
//    Fixed with Enchantment#canEnchant(ItemStack)

    public static final RegistrySupplier<Enchantment> QUANTUM_BREAKING = ENCHANTMENTS.register("quantum_breaking", QuantumBreakingEnchantment::new);
}