package net.aragurlp.smeltycraft.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import net.aragurlp.smeltycraft.container.ContainerSmeltingFurnace;
import net.aragurlp.smeltycraft.client.gui.GuiSmeltingFurnace;
import net.aragurlp.smeltycraft.reference.GUIs;
import net.aragurlp.smeltycraft.tile.TileSmeltingFurnace;
import net.aragurlp.smeltycraft.util.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler{
//    public GuiHandler()
//    {
//        LogHelper.info("GuiHandler Initialized!");
//    }
    
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity entity = world.getTileEntity(x, y, z);

        if(entity != null)
        {
            switch(ID)
            {
                case GUIs.SMELTING_FURNACE :
                    if(entity instanceof TileSmeltingFurnace)
                    {
                        return new ContainerSmeltingFurnace(player.inventory, (TileSmeltingFurnace) entity);
                    }
                    return null;
            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity entity = world.getTileEntity(x, y, z);

        if(entity != null)
        {
            switch(ID)
            {
                case GUIs.SMELTING_FURNACE :
                    if(entity instanceof TileSmeltingFurnace)
                    {
                        return new GuiSmeltingFurnace(player.inventory, (TileSmeltingFurnace) entity);
                    }
                    return null;
            }
        }
        return null;
    }
}

