<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="image/header/favicon.png">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>ご利用ガイド</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(function(){
		$("#footer").load("common/Footer.html");
	});
</script>
</head>
<body>
<div id="wrapper">
<%@ include file="Header.jsp" %>


	<h1 align="center">ご利用ガイド</h1>


	<div id="guidejump">
		<ul class="guide-list">
			<li><a href="#link1">注文方法</a></li>
			<li><a href="#link2">お支払いについて</a></li>
			<li><a href="#link3">配送について</a></li>
			<li><a href="#link4">消費税について</a></li>
			<li><a href="#link5">返品について</a></li>
		</ul>
	</div>


<div id="guide" style="padding-left:90px;">
	<section>
		<h2 style="padding-top:50px;padding-bottom:10px;" id="link1">注文方法</h2>
		<div id="guide-detail">
			<p>ネットでのご注文は24時間受け付けております。<br>
			購入したい商品をクリックし、お買い物かごに入れて下さい。<br>
			その後商品内容と金額をご確認の上、お支払い方法およびお客様情報を入力していただき、<br>
			購入決定ボタンを押してください。<br></p>
			<p style="padding-top:50px;"></p>
		</div>
	</section>

	<section>
		<h2 style="padding-top:100px;padding-bottom:10px;" id="link2">お支払いについて</h2>
		<div id="guide-detail">
			<p>・クレジットカード(VISA、MasterCard、JCB、DINERS、AMERICAN EXPRESS)<br>
			　お支払い回数は[一括払い][リボルビング払い][3回以上の分割払い]をご選択頂けます。<br>
			　(※DINERSは[一括払い][リボルビング払い]　AMERICAN EXPRESS[一括払い][分割払い]のみです)<br><br>
			・銀行先振り込み<br>
			　　お振込みにかかります手数料はお客様負担にてお願い致します。<br>
			　　お支払い期限はご注文日より【5営業日以内】となります。<br>
			　　お支払いの確認が取れない場合、ご注文はキャンセルとなりますのでご注意ください。
			<p style="padding-top:50px;"></p>
		</div>
	</section>

	<section>
		<h2 style="padding-top:100px;padding-bottom:10px;" id="link3">配送について</h2>
		<div id="guide-detail">
			<p>送料無料
			<br><br>
			【配達時間指定について】<br>
			当店では指定日配達は行っておりません。<br>
			<br>
			【長期不在・住所不備・受取拒否に関しまして】<br>
			発送後、配送業者のお荷物保持期限は「7日間」となります。<br>
			不在票がございましたら、早急に不在表記載の最寄店まで再配達をご依頼下さい。<br>
			<br>
			保管期限内にお受け取り頂けなかった場合や、住所不備・受取拒否がありますと商品が弊社に返送されてしまいます。<br>
			住所不明により返送されました場合も長期不在となります為、ご注文の際は住所に記載漏れ等がないかを十分ご確認下さいませ。<br>
			<p style="padding-top:50px;"></p>
		</div>
	</section>

	<section>
		<h2 style="padding-top:100px;padding-bottom:10px;" id="link4">消費税について</h2>
		<div id="guide-detail">
			<p>弊店は全て消費税込み価格でございます。</p>
			<p style="padding-top:50px;"></p>
		</div>
	</section>

	<section>
		<h2 style="padding-top:100px;padding-bottom:10px;" id="link5">返品について</h2>
		<div id="guide-detail">
			<p>商品管理には十分留意しておりますが、万が一不良品であった場合やご注文の商品と違う場合は商品到着後、<br>
			7日以内に当店までご連絡をお願い致します。<br>
			※期限を過ぎた場合はご対応致しかねますので予めご了承下さい。<br>
			<br>
			ご注文後の商品のキャンセル・返品・交換には初期不良の場合以外では、受け付けておりません。<br>
			お使いのＰＣモニター環境によって発色が実際のものと色が違って見える場合があります。<br>
			お客様都合によるイメージが違う（色、デザイン、サイズ）
			等の理由による返品交換は受け付けておりませんのでご了承ください。<br>
			<br>
			●ご注文後のキャンセルについて<br>
			　　ご注文後のサイズやカラーのご変更・キャンセルに関しましては、<br>
			　　在庫の差異が生じてしまい他のお客様へご迷惑をお掛けすることとなります為お受けすることができません。<br>
			　　ご注文前に必ずご注文内容をご確認下さい。<br>
			<br>
			●弊社都合による返品・交換について<br>
			　・不良品につきましては交換対応とさせていただきます。<br>
			　・返品につきましては在庫が無い場合のみ承ります。<br>
			　・商品到着より7日以内にお問い合わせフォームにてご連絡下さい。<br>
			　　弊社にて確認後、迅速に対応させていただきます。<br>
			<br>
			　--　不良による交換返品の流れ　--<br>
			　　①弊社のお問い合わせフォームに商品到着より7日以内にメールにてご連絡下さい。<br>
			　　　（ご注文者氏名、ご注文番号、商品名、不良個所の写真も併せてお送り下さい。）<br>
			　　②こちらから3営業日以内にご連絡いたします<br>
			　　③不良品の返送<br>
			　　④返送商品到着後、不良個所を確認し速やかに良品交換対応させていただきます<br>
			<br>
			●お客様都合による返品・交換について<br>
			　弊社ではお客様都合での返品は一切お断りさせて頂いております。<br>
			　以下の場合はお客様都合となります為、一切返品はお受けできませんので予めご了承下さい。<br>

			　・商品画像やモデル着用画像とイメージが違う<br>
			　　商品画像につきましては、なるべく実物に近づけて撮影いたしておりますが、<br>
			　　撮影時の光具合や閲覧頂いておりますモニターによって画像と実物のお色に多少の差異が生じる場合がございます。
			<br>
			　・糸のほつれ・シワ・キズ・匂い等による場合<br>
			　　※海外生産の商品の為、裁縫品質や検品基準が日本とは異なり、裁縫ずれや糸の始末不良、小さなキズやシワ等が発生する場合がございます。<br>
			　　　1つ1つ検品し不良品を除いたものをお届けしておりますので、上記に関しましては不良品扱いにでき兼ねますこと予めご了承下さい。<br>
			　・思っていたよりサイズが大きい、小さい<br>
			　　採寸についてはサンプルの実寸値となりますので、お手元にお届けする商品と表記寸法の間に多少の誤差が生じる場合がございます。<br>
			<br>
			　　お客様都合での交換の場合、在庫がある場合のみ対応させていただきます。<br>
			　　（※原則タグ付き初期状態のものに限ります。）<br>
			　　交換する際の手数料はお客様ご負担となりますことご了承ください。<br>
			<p style="padding-top:50px;"></p>
		</div>
	</section>

	</div>

</div>

	<!-- フッター -->
<div id="footer-wrap">
	<div id="footer"></div>
</div>
</body>
</html>