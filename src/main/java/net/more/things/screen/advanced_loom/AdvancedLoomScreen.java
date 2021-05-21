package net.more.things.screen.advanced_loom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.AbstractPressableButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class AdvancedLoomScreen extends HandledScreen<AdvancedLoomScreenHandler> {
    private static final Identifier TEXTURE = new Identifier("morethings", "textures/gui/advanced_loom.png");
    private DoneButtonWidget craftButton;
    private boolean isActive = false;

    public AdvancedLoomScreen(AdvancedLoomScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    protected void init() {
       super.init();
       this.craftButton = (DoneButtonWidget)this.addButton(new DoneButtonWidget(this.x + 60, this.y + 55));
    }
    
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        this.drawBackground(matrices, delta, mouseX, mouseY);
        super.render(matrices, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.client.getTextureManager().bindTexture(TEXTURE);

        int x = (this.width - this.backgroundWidth) / 2;
        int y = (this.height - this.backgroundHeight) / 2;
        this.drawTexture(matrices, x, y, 0, 0, this.backgroundWidth, this.backgroundHeight);

        Slot sisors_slot = ((AdvancedLoomScreenHandler)this.handler).getSissorsSlot();
        if (!sisors_slot.hasStack()) {
           this.drawTexture(matrices, this.x + sisors_slot.x + 1, this.y + sisors_slot.y + 1, 177, 61, 14, 14);
        }

        Slot head = ((AdvancedLoomScreenHandler)this.handler).getHeadSlot();
        Slot chest = ((AdvancedLoomScreenHandler)this.handler).getChestSlot();
        Slot leggins = ((AdvancedLoomScreenHandler)this.handler).getLegginsSlot();
        Slot boots = ((AdvancedLoomScreenHandler)this.handler).getBootsSlot();
        if (!head.hasStack()) {
           this.drawTexture(matrices, this.x + head.x + 1, this.y + head.y + 1, 177, 1, 14, 14);
        }
        if (!chest.hasStack()) {
           this.drawTexture(matrices, this.x + chest.x + 1, this.y + chest.y + 1, 177, 16, 14, 14);
        }
        if (!leggins.hasStack()) {
           this.drawTexture(matrices, this.x + leggins.x + 1, this.y + leggins.y + 1, 177, 31, 14, 14);
        }
        if (!boots.hasStack()) {
           this.drawTexture(matrices, this.x + boots.x + 1, this.y + boots.y + 1, 177, 46, 14, 14);
        }
    }

    @Environment(EnvType.CLIENT)
    class DoneButtonWidget extends IconButtonWidget {
        public DoneButtonWidget(int x, int y) {
            super(x, y, 192, 0, 46, 14);
        }

        public void onPress() {
           if (isActive) {
            isActive = false;
           } else if (!isActive) {
              isActive = true;
           }
        }

        public void renderToolTip(MatrixStack matrices, int mouseX, int mouseY) {
            AdvancedLoomScreen.this.renderTooltip(matrices, ScreenTexts.DONE, mouseX, mouseY);
        }
    }

    @Environment(EnvType.CLIENT)
    abstract static class IconButtonWidget extends BaseButtonWidget {
       private final int u;
       private final int v;
       private final int size_x;
       private final int size_y;
 
       protected IconButtonWidget(int x, int y, int u, int v, int size_x, int size_y) {
          super(x, y);
          this.u = u;
          this.v = v;
          this.size_x = size_x;
          this.size_y = size_y;
       }
 
       protected void renderExtra(MatrixStack matrices) {
          this.drawTexture(matrices, this.x, this.y, this.u, this.v, this.size_x, this.size_y);
       }
    }
 
    @Environment(EnvType.CLIENT)
    abstract static class BaseButtonWidget extends AbstractPressableButtonWidget {
       private boolean disabled;
 
       protected BaseButtonWidget(int x, int y) {
          super(x, y, 46, 14, LiteralText.EMPTY);
       }
 
       public void renderButton(MatrixStack matrices, int mouseX, int mouseY, float delta) {
          MinecraftClient.getInstance().getTextureManager().bindTexture(AdvancedLoomScreen.TEXTURE);
          
          //RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
          //int i = true;
          int j = 0;
          if (!this.active) {
             j = 14 * 0;
          } else if (this.disabled) {
             j = 14 * 3;
          } else if (this.isHovered()) {
             //System.out.println("test");
             j = 14 * 1;
          }
          //System.out.println(j);
 
          this.drawTexture(matrices, this.x, this.y, 192, j, this.width, this.height);
          //this.renderExtra(matrices);
       }
 
       protected abstract void renderExtra(MatrixStack matrices);
 
       public boolean isDisabled() {
          return this.disabled;
       }
 
       public void setDisabled(boolean disabled) {
          this.disabled = disabled;
       }
    }
}