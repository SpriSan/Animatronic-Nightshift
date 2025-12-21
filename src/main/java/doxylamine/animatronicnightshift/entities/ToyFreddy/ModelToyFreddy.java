package doxylamine.animatronicnightshift.entities.ToyFreddy;// Made with Blockbench 5.0.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import doxylamine.animatronicnightshift.entities.Bonnie.Bonnie;
import doxylamine.animatronicnightshift.entities.FreddyFazbear.FreddyFazbearAnimation;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class ModelToyFreddy<T extends ToyFreddy> extends HierarchicalModel<T> {

	private final ModelPart bone7;
	private final ModelPart corps;
	private final ModelPart tete;
	private final ModelPart Machoire;
	private final ModelPart bone4;
	private final ModelPart bone6;
	private final ModelPart oreilledroite;
	private final ModelPart bone21;
	private final ModelPart brasgauche;
	private final ModelPart bone23;
	private final ModelPart bone24;
	private final ModelPart bone25;
	private final ModelPart brasdroit;
	private final ModelPart bone10;
	private final ModelPart bone12;
	private final ModelPart bone2;
	private final ModelPart jambegauche;
	private final ModelPart bone3;
	private final ModelPart jambedroite;
	private final ModelPart bone;

	public ModelToyFreddy(ModelPart root) {
		this.bone7 = root.getChild("bone7");
		this.corps = this.bone7.getChild("corps");
		this.tete = this.corps.getChild("tete");
		this.Machoire = this.tete.getChild("Machoire");
		this.bone4 = this.tete.getChild("bone4");
		this.bone6 = this.tete.getChild("bone6");
		this.oreilledroite = this.tete.getChild("oreilledroite");
		this.bone21 = this.tete.getChild("bone21");
		this.brasgauche = this.corps.getChild("brasgauche");
		this.bone23 = this.brasgauche.getChild("bone23");
		this.bone24 = this.bone23.getChild("bone24");
		this.bone25 = this.bone24.getChild("bone25");
		this.brasdroit = this.corps.getChild("brasdroit");
		this.bone10 = this.brasdroit.getChild("bone10");
		this.bone12 = this.bone10.getChild("bone12");
		this.bone2 = this.bone12.getChild("bone2");
		this.jambegauche = this.bone7.getChild("jambegauche");
		this.bone3 = this.jambegauche.getChild("bone3");
		this.jambedroite = this.bone7.getChild("jambedroite");
		this.bone = this.jambedroite.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone7 = partdefinition.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(0, 31).addBox(-4.5F, -17.0F, -4.0F, 10.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(36, 56).addBox(-1.5F, -15.0F, -4.0F, 4.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 18.0F, 0.0F));

		PartDefinition corps = bone7.addOrReplaceChild("corps", CubeListBuilder.create().texOffs(0, 20).addBox(-4.5F, -15.0F, -3.5F, 9.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-5.5F, -11.0F, -4.5F, 11.0F, 11.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(0, 77).addBox(-1.0F, -14.25F, -4.225F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(76, 11).addBox(-1.0F, -10.25F, -4.975F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(76, 14).addBox(-1.0F, -7.25F, -4.975F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 5).addBox(-1.5F, -17.25F, -1.25F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -17.0F, -0.5F));

		PartDefinition cube_r1 = corps.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(72, 76).addBox(-2.0F, -0.5F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, -13.25F, -3.475F, 0.0F, 0.0F, -0.3054F));

		PartDefinition cube_r2 = corps.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(66, 76).addBox(0.0F, -0.5F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, -13.25F, -3.475F, 0.0F, 0.0F, 0.3054F));

		PartDefinition cube_r3 = corps.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(76, 49).addBox(0.0F, -1.5F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, -13.25F, -3.475F, 0.0F, 0.0F, -0.3054F));

		PartDefinition cube_r4 = corps.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(76, 46).addBox(-2.0F, -1.5F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, -13.25F, -3.475F, 0.0F, 0.0F, 0.3054F));

		PartDefinition tete = corps.addOrReplaceChild("tete", CubeListBuilder.create().texOffs(40, 11).addBox(-3.0F, -9.0F, -3.25F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-2.0F, -10.0F, -2.25F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(64, 11).addBox(-1.5F, -13.0F, -1.75F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(36, 64).addBox(-2.5F, -4.0F, -5.75F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 74).addBox(-2.0F, -2.75F, -5.5F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 20).addBox(-4.0F, -4.0F, -3.75F, 8.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(34, 31).addBox(-3.5F, -8.0F, -3.75F, 7.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(36, 75).addBox(0.5F, -6.0F, -3.35F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 18).addBox(0.825F, -5.0F, -3.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 64).addBox(-2.5F, -6.0F, -3.35F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 40).addBox(-1.825F, -5.0F, -3.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 0.25F));

		PartDefinition cube_r5 = tete.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(76, 43).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.25F, -1.975F, -4.25F, 0.0F, -0.2182F, 0.0F));

		PartDefinition cube_r6 = tete.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(76, 40).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.25F, -1.975F, -4.25F, 0.0F, 0.2182F, 0.0F));

		PartDefinition cube_r7 = tete.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(74, 65).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.5F, -3.625F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Machoire = tete.addOrReplaceChild("Machoire", CubeListBuilder.create(), PartPose.offset(0.0F, -1.5F, -3.75F));

		PartDefinition cube_r8 = Machoire.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(74, 62).addBox(-2.0F, -0.5F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.3667F, -0.6546F, 0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r9 = Machoire.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 74).addBox(-2.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.6167F, -0.9046F, 0.1309F, 0.0F, 0.0F));

		PartDefinition bone4 = tete.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.75F, -8.75F, 0.75F, 0.0F, 0.0F, -0.9599F));

		PartDefinition bone6 = tete.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offsetAndRotation(3.75F, -8.75F, 0.75F, 0.0F, 0.0F, 0.9599F));

		PartDefinition oreilledroite = tete.addOrReplaceChild("oreilledroite", CubeListBuilder.create().texOffs(12, 65).addBox(-0.6032F, -2.9846F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, -7.0F, -0.25F, 0.0F, 0.0F, -1.0036F));

		PartDefinition bone21 = tete.addOrReplaceChild("bone21", CubeListBuilder.create().texOffs(18, 51).addBox(-1.3968F, -2.9846F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.25F, -7.0F, -0.25F, 0.0F, 0.0F, 1.0036F));

		PartDefinition brasgauche = corps.addOrReplaceChild("brasgauche", CubeListBuilder.create().texOffs(24, 74).addBox(-0.1326F, -0.0382F, -1.0354F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.75F, -14.5F, 0.0F, 0.0059F, -0.0113F, -0.1727F));

		PartDefinition bone23 = brasgauche.addOrReplaceChild("bone23", CubeListBuilder.create().texOffs(58, 56).addBox(13.5F, -50.0F, -1.5F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(46, 73).addBox(14.05F, -42.0F, -1.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.8826F, 50.9618F, -0.5354F));

		PartDefinition bone24 = bone23.addOrReplaceChild("bone24", CubeListBuilder.create().texOffs(62, 18).addBox(-2.0F, 0.0F, -1.5F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(76, 5).addBox(-0.9957F, 6.8918F, -0.5034F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.5F, -41.5F, 0.0F, -0.1215F, 0.0032F, 0.0867F));

		PartDefinition bone25 = bone24.addOrReplaceChild("bone25", CubeListBuilder.create().texOffs(0, 65).addBox(-0.7457F, -5.5582F, -1.5034F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.25F, 12.95F, 0.0F));

		PartDefinition cube_r10 = bone25.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(6, 77).addBox(0.0043F, -0.0582F, -0.5034F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.25F, -5.0F, -1.0F, -0.0201F, 0.0144F, -0.0918F));

		PartDefinition cube_r11 = bone25.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(36, 68).addBox(0.0043F, -0.0582F, -0.5034F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -5.0F, -1.0F, 0.0F, 0.0F, 0.1725F));

		PartDefinition brasdroit = corps.addOrReplaceChild("brasdroit", CubeListBuilder.create().texOffs(74, 54).addBox(-3.8674F, -0.0382F, -1.0354F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.75F, -14.5F, 0.0F, 0.0059F, 0.0113F, 0.1727F));

		PartDefinition bone10 = brasdroit.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(60, 42).addBox(-17.5F, -50.0F, -1.5F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(68, 71).addBox(-17.05F, -42.0F, -1.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(12.8826F, 50.9618F, -0.5354F));

		PartDefinition bone12 = bone10.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(62, 29).addBox(-2.0F, 0.0F, -1.5F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(76, 8).addBox(-1.0043F, 6.8918F, -0.5034F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.5F, -41.5F, 0.0F, -0.1215F, -0.0032F, -0.0867F));

		PartDefinition bone2 = bone12.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(46, 68).addBox(-1.2543F, -5.5582F, -1.5034F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(74, 57).addBox(-0.7543F, -4.5582F, -2.0034F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(58, 75).addBox(-1.2543F, -5.0582F, -4.0034F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.25F, 12.95F, 0.0F));

		PartDefinition cube_r12 = bone2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(10, 77).addBox(-1.0043F, -0.0582F, -0.5034F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.25F, -5.0F, -1.0F, -0.0201F, -0.0144F, 0.0918F));

		PartDefinition cube_r13 = bone2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(58, 68).addBox(-1.0043F, -0.0582F, -0.5034F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -5.0F, -1.0F, 0.0F, 0.0F, -0.1725F));

		PartDefinition jambegauche = bone7.addOrReplaceChild("jambegauche", CubeListBuilder.create(), PartPose.offsetAndRotation(2.5F, -14.5F, -1.75F, 0.1282F, 0.0205F, 0.0065F));

		PartDefinition cube_r14 = jambegauche.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(68, 68).addBox(1.0F, 7.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7F, 1.0F, 1.0F, -0.1309F, -0.2182F, 0.0F));

		PartDefinition cube_r15 = jambegauche.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(24, 42).addBox(0.0F, -0.7692F, -1.7063F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -0.25F, 0.0F, -0.1309F, -0.2182F, 0.0F));

		PartDefinition bone3 = jambegauche.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(1.25F, 8.5F, 0.0F));

		PartDefinition cube_r16 = bone3.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(42, 42).addBox(-0.2164F, 0.0407F, -2.8881F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, -0.2182F, 0.0F));

		PartDefinition cube_r17 = bone3.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 70).addBox(0.8049F, -0.9511F, -1.7621F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 10.0F, 0.0F, 0.0F, -0.2182F, 0.0F));

		PartDefinition cube_r18 = bone3.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 40).addBox(-0.2233F, -0.6593F, -5.8886F, 4.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 10.0F, 0.0F, -0.134F, -0.2156F, 0.0318F));

		PartDefinition jambedroite = bone7.addOrReplaceChild("jambedroite", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, -14.5F, -1.75F, 0.1282F, -0.0205F, -0.0065F));

		PartDefinition cube_r19 = jambedroite.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(12, 70).addBox(-4.0F, 7.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7F, 1.0F, 1.0F, -0.1309F, 0.2182F, 0.0F));

		PartDefinition cube_r20 = jambedroite.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 51).addBox(-4.0F, -0.7692F, -1.7063F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -0.25F, 0.0F, -0.1309F, 0.2182F, 0.0F));

		PartDefinition bone = jambedroite.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(-1.25F, 8.5F, 0.0F));

		PartDefinition cube_r21 = bone.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(18, 56).addBox(-3.7836F, 0.0407F, -2.8881F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.2182F, 0.0F));

		PartDefinition cube_r22 = bone.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(24, 70).addBox(-3.8049F, -0.9511F, -1.7621F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 10.0F, 0.0F, 0.0F, 0.2182F, 0.0F));

		PartDefinition cube_r23 = bone.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(40, 0).addBox(-3.7767F, -0.6593F, -5.8886F, 4.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 10.0F, 0.0F, -0.134F, 0.2156F, -0.0318F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

    @Override
    public ModelPart root() {
        return bone7;
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animate(((ToyFreddy) entity).crawlingAnimationState, FreddyFazbearAnimation.crawl, ageInTicks, 1f);


        this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

        this.jambedroite.xRot += Mth.cos(limbSwing * 0.3F) * 0.8F * limbSwingAmount * 0.5F;
        this.jambegauche.xRot += Mth.cos(limbSwing * 0.3F + (float)Math.PI) * 0.8F * limbSwingAmount * 0.5F;
        this.jambedroite.yRot += 0.0F;
        this.jambegauche.yRot += 0.0F;

        this.brasgauche.xRot += Mth.cos(limbSwing * 0.3F) * 0.8F * limbSwingAmount * 0.5F;
        this.brasdroit.xRot += Mth.cos(limbSwing * 0.3F + (float)Math.PI) * 0.8F * limbSwingAmount * 0.5F;
        this.brasgauche.yRot += 0.0F;
        this.brasdroit.yRot += 0.0F;

    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {

        float yawClamped = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        float pitchClamped = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        float yawRad = yawClamped * ((float)Math.PI / 180F);
        float pitchRad = pitchClamped * ((float)Math.PI / 180F);

        this.tete.yRot += yawRad;
        this.tete.xRot += pitchRad;
    }
}