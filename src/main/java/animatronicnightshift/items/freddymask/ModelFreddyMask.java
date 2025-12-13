package animatronicnightshift.items.freddymask;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

public class ModelFreddyMask extends Model {
    private final ModelPart tete;

    public ModelFreddyMask(ModelPart root) {
        super(RenderType::entityCutoutNoCull);
        this.tete = root.getChild("tete");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition tete = partdefinition.addOrReplaceChild("tete", CubeListBuilder.create().texOffs(54, 53).addBox(-3.0F, -7.0F, -2.5F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(64, 0).addBox(-2.0F, -8.0F, -1.5F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(16, 64).addBox(-1.5F, -10.0F, -1.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(64, 5).addBox(-3.0F, -2.0F, -5.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 20).addBox(-4.5F, -3.0F, -3.0F, 9.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(32, 20).addBox(-3.5F, -6.0F, -3.0F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, -1.0F));

        PartDefinition cube_r1 = tete.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(36, 72).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, -2.875F, -0.1309F, 0.0F, 0.0F));

        PartDefinition Machoire = tete.addOrReplaceChild("Machoire", CubeListBuilder.create(), PartPose.offset(0.0F, -0.25F, 2.0F));

        PartDefinition cube_r2 = Machoire.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(38, 0).addBox(-3.0F, -0.2164F, -7.9763F, 6.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition bone4 = tete.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.75F, -6.75F, 1.5F, 0.0F, 0.0F, -0.9599F));

        PartDefinition bone6 = tete.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offsetAndRotation(3.75F, -6.75F, 1.5F, 0.0F, 0.0F, 0.9599F));

        PartDefinition oreilledroite = tete.addOrReplaceChild("oreilledroite", CubeListBuilder.create().texOffs(50, 67).addBox(-0.3532F, -1.9846F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 74).addBox(-0.8532F, -3.9846F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, -5.0F, 0.5F, 0.0F, 0.0F, -1.0036F));

        PartDefinition bone21 = tete.addOrReplaceChild("bone21", CubeListBuilder.create().texOffs(6, 74).addBox(-1.1468F, -3.9846F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(50, 67).addBox(-0.6468F, -1.9846F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.25F, -5.0F, 0.5F, 0.0F, 0.0F, 1.0036F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        tete.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public ModelPart getTete() {
        return this.tete;
    }
}