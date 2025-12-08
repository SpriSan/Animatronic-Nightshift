package animatronicnightshift.entities.Foxy;// Made with Blockbench 5.0.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import animatronicnightshift.entities.FreddyFazbear.FreddyFazbear;
import animatronicnightshift.entities.FreddyFazbear.FreddyFazbearAnimation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class ModelFoxy<T extends Foxy> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart bone7;
	private final ModelPart corps;
	private final ModelPart brasdroit;
	private final ModelPart bone10;
	private final ModelPart bone12;
	private final ModelPart bone2;
	private final ModelPart brasgauche;
	private final ModelPart bone23;
	private final ModelPart bone24;
	private final ModelPart bone25;
	private final ModelPart tete;
	private final ModelPart Machoire;
	private final ModelPart bone4;
	private final ModelPart bone6;
	private final ModelPart oreilledroite;
	private final ModelPart bone21;
	private final ModelPart jambedroite;
	private final ModelPart bone;
	private final ModelPart jambegauche;
	private final ModelPart bone3;

	public ModelFoxy(ModelPart root) {
		this.bone7 = root.getChild("bone7");
		this.corps = this.bone7.getChild("corps");
		this.brasdroit = this.corps.getChild("brasdroit");
		this.bone10 = this.brasdroit.getChild("bone10");
		this.bone12 = this.bone10.getChild("bone12");
		this.bone2 = this.bone12.getChild("bone2");
		this.brasgauche = this.corps.getChild("brasgauche");
		this.bone23 = this.brasgauche.getChild("bone23");
		this.bone24 = this.bone23.getChild("bone24");
		this.bone25 = this.bone24.getChild("bone25");
		this.tete = this.corps.getChild("tete");
		this.Machoire = this.tete.getChild("Machoire");
		this.bone4 = this.tete.getChild("bone4");
		this.bone6 = this.tete.getChild("bone6");
		this.oreilledroite = this.tete.getChild("oreilledroite");
		this.bone21 = this.tete.getChild("bone21");
		this.jambedroite = this.bone7.getChild("jambedroite");
		this.bone = this.jambedroite.getChild("bone");
		this.jambegauche = this.bone7.getChild("jambegauche");
		this.bone3 = this.jambegauche.getChild("bone3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone7 = partdefinition.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(32, 32).addBox(-3.5F, -19.0F, -3.0F, 8.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(62, 22).addBox(-1.0F, -17.0F, -3.0F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 18.0F, 0.0F));

		PartDefinition corps = bone7.addOrReplaceChild("corps", CubeListBuilder.create().texOffs(13, 84).addBox(-1.0F, -14.25F, -0.75F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 3).mirror().addBox(-4.5F, -15.0F, -3.0F, 9.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 76).mirror().addBox(-1.5F, -17.25F, -1.25F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(22, 85).mirror().addBox(-4.5F, -14.25F, -0.25F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, -17.0F, -0.5F));

		PartDefinition cube_r1 = corps.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(25, 85).addBox(-4.5F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.45F, -10.0F, 0.25F, 0.0F, 0.0F, 0.9468F));

		PartDefinition cube_r2 = corps.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(25, 85).mirror().addBox(-1.5F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.45F, -10.0F, 0.25F, 0.0F, 0.0F, -0.9468F));

		PartDefinition brasdroit = corps.addOrReplaceChild("brasdroit", CubeListBuilder.create().texOffs(18, 46).addBox(-1.9141F, -0.4669F, -1.0037F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.75F, -14.5F, 0.0F, 0.0053F, 0.0151F, 0.2161F));

		PartDefinition bone10 = brasdroit.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(79, 27).addBox(-16.5F, -50.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 97).addBox(-17.5F, -50.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(44, 72).addBox(-17.0F, -42.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(14.8359F, 50.5331F, -0.0037F));

		PartDefinition bone12 = bone10.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(79, 27).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(76, 36).addBox(-2.4981F, 6.9931F, -1.9992F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(76, 42).addBox(-1.9981F, 7.9931F, -1.4992F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(64, 29).mirror().addBox(-2.0F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-15.5F, -41.5F, 0.0F, -0.119F, -0.0035F, -0.1303F));

		PartDefinition bone2 = bone12.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(72, 46).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.125F)), PartPose.offset(-0.4981F, 8.8681F, 0.0008F));

		PartDefinition cube_r3 = bone2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(78, 47).addBox(-0.5F, -0.8948F, -1.8696F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.125F)), PartPose.offsetAndRotation(0.0F, 4.375F, -0.775F, -0.6342F, 0.0302F, -0.06F));

		PartDefinition cube_r4 = bone2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(78, 47).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.125F)), PartPose.offsetAndRotation(0.0F, 3.4F, 0.275F, 0.48F, 0.0F, 0.0F));

		PartDefinition cube_r5 = bone2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(72, 46).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.125F)), PartPose.offsetAndRotation(0.0F, 2.15F, 0.775F, -0.2632F, 0.0F, 0.0F));

		PartDefinition cube_r6 = bone2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(72, 46).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.125F)), PartPose.offsetAndRotation(0.0F, 0.975F, 0.15F, 0.6109F, 0.0F, 0.0F));

		PartDefinition brasgauche = corps.addOrReplaceChild("brasgauche", CubeListBuilder.create().texOffs(39, 69).addBox(-1.0859F, -0.4669F, -1.0037F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.75F, -14.5F, 0.0F, 0.0053F, -0.0151F, -0.2161F));

		PartDefinition bone23 = brasgauche.addOrReplaceChild("bone23", CubeListBuilder.create().texOffs(79, 27).addBox(15.5F, -50.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(68, 72).addBox(15.0F, -42.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 85).mirror().addBox(14.5F, -50.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-14.8359F, 50.5331F, -0.0037F));

		PartDefinition bone24 = bone23.addOrReplaceChild("bone24", CubeListBuilder.create().texOffs(79, 27).addBox(0.0F, 0.0F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 29).addBox(-1.0F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(20, 73).addBox(-0.5019F, 6.9931F, -0.9992F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.5F, -41.5F, 0.0F, -0.119F, 0.0035F, 0.1303F));

		PartDefinition bone25 = bone24.addOrReplaceChild("bone25", CubeListBuilder.create().texOffs(38, 64).addBox(-0.2519F, 0.5431F, -1.9992F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 6.95F, 0.0F, 0.0021F, -0.0281F, 0.173F));

		PartDefinition cube_r7 = bone25.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(50, 75).addBox(0.4938F, 0.0977F, -0.9892F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.25F, 1.0F, -1.0F, -0.0201F, 0.0144F, -0.0918F));

		PartDefinition cube_r8 = bone25.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 67).addBox(0.5082F, -0.0431F, -0.9992F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.0F, -1.0F, 0.0F, 0.0F, 0.1725F));

		PartDefinition tete = corps.addOrReplaceChild("tete", CubeListBuilder.create().texOffs(71, 56).addBox(-3.0F, -9.0F, -3.5F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(84, 70).addBox(-0.5F, -10.775F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(65, 4).addBox(-1.5F, -4.0F, -11.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(77, 6).addBox(-2.0F, -4.0F, -8.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(30, 122).addBox(-1.5F, -2.0F, -11.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(42, 123).addBox(-2.0F, -2.0F, -8.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(70, 64).addBox(-1.5F, -2.25F, 0.75F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(72, 51).mirror().addBox(0.5F, -6.25F, -3.6F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(72, 55).mirror().addBox(0.825F, -5.25F, -3.65F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(32, 16).mirror().addBox(-3.5F, -8.0F, -4.0F, 7.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -16.0F, 0.5F));

		PartDefinition cube_r9 = tete.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(84, 70).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.5F, -8.725F, -0.5F, 0.0F, 0.0F, 0.48F));

		PartDefinition cube_r10 = tete.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(17, 36).addBox(-2.0F, -2.25F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -1.75F, -2.475F, 0.0009F, -0.0003F, 0.0437F));

		PartDefinition cube_r11 = tete.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(18, 41).addBox(0.0F, -1.25F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -3.75F, -2.475F, 0.0F, 0.0F, -0.1745F));

		PartDefinition cube_r12 = tete.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(16, 36).addBox(0.0F, -2.25F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -1.75F, -2.475F, 0.0009F, 0.0003F, -0.0437F));

		PartDefinition cube_r13 = tete.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(19, 41).addBox(-1.0F, -1.25F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -3.75F, -2.475F, 0.0F, 0.0F, 0.1745F));

		PartDefinition cube_r14 = tete.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(36, 72).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.5F, -8.875F, -0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r15 = tete.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(84, 70).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.5F, -8.725F, -0.5F, 0.0F, 0.0F, -0.48F));

		PartDefinition Machoire = tete.addOrReplaceChild("Machoire", CubeListBuilder.create(), PartPose.offset(0.0F, -2.25F, 1.0F));

		PartDefinition cube_r16 = Machoire.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(9, 115).addBox(-1.0F, -1.2164F, -12.9763F, 4.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(36, 0).addBox(-1.0F, -0.2164F, -12.9763F, 4.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 1.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition bone4 = tete.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.75F, -8.75F, 0.5F, 0.0F, 0.0F, -0.9599F));

		PartDefinition bone6 = tete.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offsetAndRotation(3.75F, -8.75F, 0.5F, 0.0F, 0.0F, 0.9599F));

		PartDefinition oreilledroite = tete.addOrReplaceChild("oreilledroite", CubeListBuilder.create().texOffs(50, 67).addBox(-0.3532F, -1.9846F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(13, 79).addBox(-1.3532F, -4.9846F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(30, 79).addBox(-0.8532F, -6.9846F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, -7.0F, -0.5F, 0.0F, 0.0F, -0.8727F));

		PartDefinition bone21 = tete.addOrReplaceChild("bone21", CubeListBuilder.create().texOffs(23, 79).addBox(-1.1468F, -6.9846F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 67).addBox(-0.6468F, -1.9846F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(13, 79).mirror().addBox(-1.6468F, -4.9846F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.25F, -7.0F, -0.5F, 0.0F, 0.0F, 0.8727F));

		PartDefinition jambedroite = bone7.addOrReplaceChild("jambedroite", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.175F, -14.5F, -1.175F, 0.1282F, -0.0205F, -0.0065F));

		PartDefinition cube_r17 = jambedroite.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 115).mirror().addBox(-3.075F, -3.0443F, -0.6563F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1, 42).addBox(-4.0F, -2.7692F, -1.7063F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -0.25F, 0.0F, -0.1309F, 0.2182F, 0.0F));

		PartDefinition cube_r18 = jambedroite.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 77).addBox(-4.075F, 5.9558F, -1.6563F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.625F, -0.575F, 0.525F, -0.1309F, 0.2182F, 0.0F));

		PartDefinition bone = jambedroite.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(-1.25F, 7.5F, 0.0F));

		PartDefinition cube_r19 = bone.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(26, 63).addBox(-3.7767F, 0.3407F, 0.1114F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1F, 10.275F, -5.625F, -0.131F, 0.0426F, -0.0086F));

		PartDefinition cube_r20 = bone.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(18, 50).addBox(-2.7836F, -0.9593F, -1.8881F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 1.0F, 0.25F, 0.0F, 0.2182F, 0.0F));

		PartDefinition cube_r21 = bone.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(29, 53).addBox(-3.7767F, 0.3407F, -3.8886F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 11.0F, 0.0F, -0.134F, 0.2156F, -0.0318F));

		PartDefinition cube_r22 = bone.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(26, 63).addBox(-3.7767F, 0.3407F, 0.1114F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.275F, 10.225F, -5.975F, -0.1415F, 0.3885F, -0.0569F));

		PartDefinition jambegauche = bone7.addOrReplaceChild("jambegauche", CubeListBuilder.create(), PartPose.offsetAndRotation(2.175F, -14.5F, -1.175F, 0.1282F, 0.0205F, 0.0065F));

		PartDefinition cube_r23 = jambegauche.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 27).mirror().addBox(0.0F, -2.7692F, -1.7063F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 115).addBox(1.075F, -3.0443F, -0.6563F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -0.25F, 0.0F, -0.1309F, -0.2182F, 0.0F));

		PartDefinition cube_r24 = jambegauche.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 77).addBox(1.075F, 5.9558F, -1.6563F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.625F, -0.575F, 0.525F, -0.1309F, -0.2182F, 0.0F));

		PartDefinition bone3 = jambegauche.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(1.25F, 7.5F, 0.0F));

		PartDefinition cube_r25 = bone3.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(18, 50).mirror().addBox(0.7836F, -0.9593F, -1.8881F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 1.0F, 0.25F, 0.0F, -0.2182F, 0.0F));

		PartDefinition cube_r26 = bone3.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(26, 63).mirror().addBox(1.7767F, 0.3407F, 0.1114F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.275F, 10.225F, -5.975F, -0.1415F, -0.3885F, 0.0569F));

		PartDefinition cube_r27 = bone3.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(26, 63).mirror().addBox(1.7767F, 0.3407F, 0.1114F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.1F, 10.275F, -5.625F, -0.131F, -0.0426F, 0.0086F));

		PartDefinition cube_r28 = bone3.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(33, 44).addBox(-0.2233F, 0.3407F, -3.8886F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 11.0F, 0.0F, -0.134F, -0.2156F, 0.0318F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animate(((Foxy) entity).idleAnimationState, FoxyAnimations.day, ageInTicks, 1f);

        this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

        this.jambedroite.xRot += Mth.cos(limbSwing * 0.5F) * 0.8F * limbSwingAmount * 0.5F;
        this.jambegauche.xRot += Mth.cos(limbSwing * 0.5F + (float)Math.PI) * 0.8F * limbSwingAmount * 0.5F;
        this.jambedroite.yRot += 0.0F;
        this.jambegauche.yRot += 0.0F;

        this.brasgauche.xRot += Mth.cos(limbSwing * 0.5F) * 0.8F * limbSwingAmount * 0.5F;
        this.brasdroit.xRot += Mth.cos(limbSwing * 0.5F + (float)Math.PI) * 0.8F * limbSwingAmount * 0.5F;
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

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bone7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return bone7;
    }
}