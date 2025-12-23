package doxylamine.animatronicnightshift.entities.Springtrap;// Made with Blockbench 5.0.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import doxylamine.animatronicnightshift.entities.FreddyFazbear.FreddyFazbear;
import doxylamine.animatronicnightshift.entities.FreddyFazbear.FreddyFazbearAnimation;
import doxylamine.animatronicnightshift.entities.Springtrap.Springtrap;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class ModelSpringtrap<T extends Springtrap> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart bone7;
	private final ModelPart corps;
	private final ModelPart brasdroit;
	private final ModelPart bone10;
	private final ModelPart bone12;
	private final ModelPart bone2;
	private final ModelPart bone9;
	private final ModelPart brasgauche;
	private final ModelPart bone23;
	private final ModelPart bone24;
	private final ModelPart bone25;
	private final ModelPart tete;
	private final ModelPart Machoire;
	private final ModelPart bone4;
	private final ModelPart bone6;
	private final ModelPart oreilledroite;
	private final ModelPart bone5;
	private final ModelPart bone21;
	private final ModelPart bone8;
	private final ModelPart jambegauche;
	private final ModelPart bone3;
	private final ModelPart jambedroite;
	private final ModelPart bone;

	public ModelSpringtrap(ModelPart root) {
		this.bone7 = root.getChild("bone7");
		this.corps = this.bone7.getChild("corps");
		this.brasdroit = this.corps.getChild("brasdroit");
		this.bone10 = this.brasdroit.getChild("bone10");
		this.bone12 = this.bone10.getChild("bone12");
		this.bone2 = this.bone12.getChild("bone2");
		this.bone9 = this.bone2.getChild("bone9");
		this.brasgauche = this.corps.getChild("brasgauche");
		this.bone23 = this.brasgauche.getChild("bone23");
		this.bone24 = this.bone23.getChild("bone24");
		this.bone25 = this.bone24.getChild("bone25");
		this.tete = this.corps.getChild("tete");
		this.Machoire = this.tete.getChild("Machoire");
		this.bone4 = this.tete.getChild("bone4");
		this.bone6 = this.tete.getChild("bone6");
		this.oreilledroite = this.tete.getChild("oreilledroite");
		this.bone5 = this.tete.getChild("bone5");
		this.bone21 = this.tete.getChild("bone21");
		this.bone8 = this.corps.getChild("bone8");
		this.jambegauche = this.bone7.getChild("jambegauche");
		this.bone3 = this.jambegauche.getChild("bone3");
		this.jambedroite = this.bone7.getChild("jambedroite");
		this.bone = this.jambedroite.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone7 = partdefinition.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(30, 30).addBox(-4.0F, -17.0F, -4.0F, 9.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(60, 20).addBox(-1.5F, -15.0F, -4.0F, 4.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 18.0F, 0.0F));

		PartDefinition corps = bone7.addOrReplaceChild("corps", CubeListBuilder.create().texOffs(0, 30).addBox(-4.0F, -15.0F, -3.5F, 8.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-5.0F, -11.0F, -4.5F, 10.0F, 11.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(35, 80).addBox(-1.0F, -10.25F, -4.975F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -17.0F, -0.5F));

		PartDefinition brasdroit = corps.addOrReplaceChild("brasdroit", CubeListBuilder.create().texOffs(18, 46).addBox(-3.8674F, -0.0382F, -1.0354F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.75F, -14.5F, 0.0F, 0.0059F, 0.0113F, 0.1727F));

		PartDefinition bone10 = brasdroit.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(0, 55).addBox(-17.5F, -50.0F, -1.5F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 90).addBox(-16.5F, -50.0F, -0.5F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(44, 72).addBox(-16.5F, -42.0F, -0.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 101).mirror().addBox(-16.0F, -50.0F, 0.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(12.8826F, 50.9618F, -0.5354F));

		PartDefinition bone12 = bone10.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(62, 9).addBox(-2.0F, 0.0F, -1.5F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 101).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(9, 91).mirror().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(72, 45).addBox(-1.0043F, 6.8918F, -0.5034F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.5F, -41.5F, 0.0F, -0.1215F, -0.0032F, -0.0867F));

		PartDefinition bone2 = bone12.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(18, 41).addBox(-1.2543F, -0.0582F, -2.0034F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.25F, 7.45F, 0.5F));

		PartDefinition cube_r1 = bone2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(50, 64).addBox(-1.0043F, -0.0582F, -0.5034F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.25F, 0.5F, -1.5F, -0.0201F, -0.0144F, 0.0918F));

		PartDefinition cube_r2 = bone2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(28, 64).addBox(-1.0043F, -0.0582F, -0.5034F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.5F, -1.5F, 0.0F, 0.0F, -0.1725F));

		PartDefinition bone9 = bone2.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(75, 111).addBox(-0.5F, -3.5F, -2.45F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(83, 112).addBox(-0.5F, -4.5F, -2.45F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 113).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(79, 115).addBox(-0.5F, 3.0F, -3.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(47, 107).addBox(-0.5F, 0.0F, 1.0F, 1.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -10.0F));

		PartDefinition brasgauche = corps.addOrReplaceChild("brasgauche", CubeListBuilder.create().texOffs(38, 69).addBox(-0.1326F, -0.0382F, -1.0354F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.75F, -14.5F, 0.0F, 0.0059F, -0.0113F, -0.1727F));

		PartDefinition bone23 = brasgauche.addOrReplaceChild("bone23", CubeListBuilder.create().texOffs(54, 60).addBox(13.5F, -50.0F, -1.5F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 101).addBox(15.0F, -50.0F, 0.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 90).addBox(14.5F, -50.0F, -0.5F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(68, 72).addBox(14.5F, -42.0F, -0.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.8826F, 50.9618F, -0.5354F));

		PartDefinition bone24 = bone23.addOrReplaceChild("bone24", CubeListBuilder.create().texOffs(9, 91).addBox(-1.0F, 0.0F, -0.5F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 101).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 73).addBox(-0.9957F, 6.8918F, -0.5034F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(79, 9).mirror().addBox(-2.0F, 0.0F, -1.5F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(15.5F, -41.5F, 0.0F, -0.1215F, 0.0032F, 0.0867F));

		PartDefinition bone25 = bone24.addOrReplaceChild("bone25", CubeListBuilder.create().texOffs(38, 64).addBox(-0.7457F, -0.0582F, -2.0034F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.25F, 7.45F, 0.5F));

		PartDefinition cube_r3 = bone25.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(50, 75).addBox(0.0043F, -0.0582F, -0.5034F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.25F, 0.5F, -1.5F, -0.0201F, 0.0144F, -0.0918F));

		PartDefinition cube_r4 = bone25.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 67).addBox(0.0043F, -0.0582F, -0.5034F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.5F, -1.5F, 0.0F, 0.0F, 0.1725F));

		PartDefinition tete = corps.addOrReplaceChild("tete", CubeListBuilder.create().texOffs(54, 53).addBox(-3.0F, -9.0F, -3.5F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(64, 5).addBox(-2.0F, -4.0F, -6.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(70, 64).addBox(-1.5F, -2.25F, 0.75F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1, 20).addBox(-3.5F, -5.0F, -4.0F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(32, 20).addBox(-3.5F, -8.0F, -4.0F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(72, 51).mirror().addBox(0.5F, -6.0F, -3.6F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(72, 55).mirror().addBox(0.825F, -5.0F, -3.65F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(72, 51).addBox(-2.5F, -6.0F, -3.6F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(72, 55).addBox(-1.825F, -5.0F, -3.65F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 0.5F));

		PartDefinition cube_r5 = tete.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(36, 72).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.5F, -3.875F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Machoire = tete.addOrReplaceChild("Machoire", CubeListBuilder.create(), PartPose.offset(0.0F, -2.25F, 1.0F));

		PartDefinition cube_r6 = Machoire.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(38, 0).addBox(-3.0F, -0.2164F, -7.9763F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 1.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition bone4 = tete.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.75F, -8.75F, 0.5F, 0.0F, 0.0F, -0.9599F));

		PartDefinition bone6 = tete.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offsetAndRotation(3.75F, -8.75F, 0.5F, 0.0F, 0.0F, 0.9599F));

		PartDefinition oreilledroite = tete.addOrReplaceChild("oreilledroite", CubeListBuilder.create().texOffs(50, 67).addBox(-0.3532F, -1.9846F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(17, 80).addBox(-1.3532F, -3.9846F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 89).addBox(-0.8532F, -4.7346F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.175F)), PartPose.offsetAndRotation(-2.0F, -7.25F, -0.5F, 0.3363F, 0.0741F, -0.3851F));

		PartDefinition cube_r7 = oreilledroite.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(32, 0).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8532F, -4.4846F, -0.25F, 0.4363F, 0.0F, -0.3927F));

		PartDefinition bone5 = tete.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(112, 17).addBox(-1.0F, 3.5F, -4.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(106, 0).addBox(-2.0F, -1.5F, -4.0F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(110, 11).addBox(-1.5F, -2.5F, -3.5F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -6.25F, 1.0F));

		PartDefinition bone21 = tete.addOrReplaceChild("bone21", CubeListBuilder.create().texOffs(50, 67).addBox(-0.6468F, -1.9846F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(17, 80).mirror().addBox(-1.6468F, -7.9846F, -0.5F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -7.25F, -0.5F, 0.3363F, -0.0741F, 0.3851F));

		PartDefinition cube_r8 = bone21.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(10, 89).mirror().addBox(-2.0F, -3.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.125F)).mirror(false), PartPose.offsetAndRotation(0.7282F, -7.7346F, 0.625F, 0.4608F, -0.1393F, 0.2727F));

		PartDefinition cube_r9 = bone21.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(26, 82).mirror().addBox(-1.0F, -4.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(26, 84).mirror().addBox(-2.0F, -2.0F, -1.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.3532F, -7.9846F, 0.5F, 0.4608F, -0.1393F, 0.2727F));

		PartDefinition bone8 = corps.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(47, 126).mirror().addBox(-4.5F, -14.25F, -0.25F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(38, 111).addBox(-1.0F, -14.25F, -0.75F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 111).addBox(-1.5F, -12.25F, -1.25F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(2, 108).addBox(-2.0F, -11.25F, -1.75F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(25, 120).addBox(-1.5F, -17.25F, -1.25F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(2, 117).addBox(-2.0F, -14.75F, -1.75F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r10 = bone8.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(47, 126).addBox(-4.5F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.45F, -10.0F, 0.25F, 0.0F, 0.0F, 0.9468F));

		PartDefinition cube_r11 = bone8.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(2, 123).mirror().addBox(-1.5F, -0.5F, -0.5F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.95F, -10.0F, -0.25F, 0.0F, 0.0F, -0.9468F));

		PartDefinition cube_r12 = bone8.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(47, 126).mirror().addBox(-1.5F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.45F, -10.0F, 0.25F, 0.0F, 0.0F, -0.9468F));

		PartDefinition cube_r13 = bone8.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(2, 123).addBox(-4.5F, -0.5F, -0.5F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.95F, -10.0F, -0.25F, 0.0F, 0.0F, 0.9468F));

		PartDefinition jambegauche = bone7.addOrReplaceChild("jambegauche", CubeListBuilder.create(), PartPose.offsetAndRotation(2.5F, -14.5F, -1.75F, 0.1282F, 0.0205F, 0.0065F));

		PartDefinition cube_r14 = jambegauche.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(60, 72).addBox(1.0F, 7.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.0F, 0.5F, -0.1309F, -0.2182F, 0.0F));

		PartDefinition cube_r15 = jambegauche.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(23, 99).addBox(1.0F, -0.7692F, -0.7063F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -0.225F, 0.375F, -0.1309F, -0.2182F, 0.0F));

		PartDefinition cube_r16 = jambegauche.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(36, 50).addBox(0.0F, -0.7692F, -1.7063F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -0.25F, 0.0F, -0.1309F, -0.2182F, 0.0F));

		PartDefinition bone3 = jambegauche.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(1.25F, 8.5F, 0.0F));

		PartDefinition cube_r17 = bone3.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(52, 72).addBox(-0.9787F, -1.941F, -0.1622F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1254F, 1.5657F, -2.5718F, 0.2182F, -0.2182F, 0.0F));

		PartDefinition cube_r18 = bone3.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(54, 39).addBox(-0.2164F, 0.0407F, -2.8881F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, -0.2182F, 0.0F));

		PartDefinition cube_r19 = bone3.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(32, 99).addBox(0.7836F, 0.0407F, -0.8881F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.875F, 0.0F, -0.5F, 0.0F, -0.2182F, 0.0F));

		PartDefinition cube_r20 = bone3.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(113, 1).addBox(0.8049F, -0.9511F, -1.7621F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 9.25F, 0.0F, 0.0F, -0.2182F, 0.0F));

		PartDefinition cube_r21 = bone3.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(109, 4).addBox(0.7767F, -0.6593F, -4.8886F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 9.6F, 0.0F, -0.0511F, -0.2156F, 0.0318F));

		PartDefinition cube_r22 = bone3.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(30, 39).addBox(-0.2233F, -0.6593F, -5.8886F, 4.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 10.0F, 0.0F, -0.134F, -0.2156F, 0.0318F));

		PartDefinition jambedroite = bone7.addOrReplaceChild("jambedroite", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, -14.5F, -1.75F, 0.1282F, -0.0205F, -0.0065F));

		PartDefinition cube_r23 = jambedroite.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(23, 99).mirror().addBox(-3.0F, -0.7692F, -0.7063F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -0.225F, 0.375F, -0.1309F, 0.2182F, 0.0F));

		PartDefinition cube_r24 = jambedroite.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(72, 39).addBox(-3.0F, 7.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.0F, 0.5F, -0.1309F, 0.2182F, 0.0F));

		PartDefinition cube_r25 = jambedroite.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 41).addBox(-4.0F, -0.7692F, -1.7063F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -0.25F, 0.0F, -0.1309F, 0.2182F, 0.0F));

		PartDefinition bone = jambedroite.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(-1.25F, 8.5F, 0.0F));

		PartDefinition cube_r26 = bone.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(54, 39).mirror().addBox(-3.7836F, 0.0407F, -2.8881F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.2182F, 0.0F));

		PartDefinition cube_r27 = bone.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(30, 39).mirror().addBox(-3.7767F, -0.6593F, -5.8886F, 4.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 10.0F, 0.0F, -0.134F, 0.2156F, -0.0318F));

		PartDefinition cube_r28 = bone.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(72, 42).addBox(-2.0213F, -1.941F, -0.1622F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1254F, 1.5657F, -2.5718F, 0.2182F, 0.2182F, 0.0F));

		PartDefinition cube_r29 = bone.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(32, 99).addBox(-2.7836F, 0.0407F, -0.8881F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.875F, 0.0F, -0.5F, 0.0F, 0.2182F, 0.0F));

		PartDefinition cube_r30 = bone.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(112, 3).addBox(-3.8049F, -1.9511F, -1.7621F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 10.0F, -0.25F, 0.0F, 0.2182F, 0.0F));

		PartDefinition cube_r31 = bone.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(106, 0).addBox(-3.7767F, -0.6593F, -4.8886F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 9.6F, 0.0F, -0.0511F, 0.2156F, -0.0318F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animate(((Springtrap) entity).idleAnimationState, SpringtrapAnimations.pose_hache, ageInTicks, 1f);
        this.animate(((Springtrap) entity).jumpscareAnimationState, FreddyFazbearAnimation.jumpscare, ageInTicks, 1f);
        this.animate(((Springtrap) entity).crawlingAnimationState, FreddyFazbearAnimation.crawl, ageInTicks, 1f);

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

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bone7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);


    }

    @Override
    public ModelPart root() {
        return bone7;
    }
}