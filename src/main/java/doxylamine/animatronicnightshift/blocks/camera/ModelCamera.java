package doxylamine.animatronicnightshift.blocks.camera;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import doxylamine.animatronicnightshift.AnimatronicNightshift;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;


public class ModelCamera extends Model {

	final ModelPart bone;
    final ModelPart bb_main;
	final ModelPart bone2;

	public ModelCamera(ModelPart root) {
    	super(RenderType::entityCutout);
		this.bone2 = root.getChild("bone2");
		this.bone = this.bone2.getChild("bone");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(0.0F, 16.5943F, 3.5232F));

		PartDefinition bone = bone2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.05F, -7.625F, 4.0F, 2.0F, 10.0F, new CubeDeformation(0.1F))
		.texOffs(0, 12).addBox(-2.0F, -2.95F, -6.875F, 4.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 24).addBox(-1.0F, -5.8556F, 3.6481F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(12, 24).addBox(-2.0F, -9.0F, 7.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(22, 24).addBox(-1.0F, -7.8556F, 2.6481F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public static final ResourceLocation getTextureLocation() {
        return new ResourceLocation(AnimatronicNightshift.MODID, "textures/entity/camera.png");
    }
}