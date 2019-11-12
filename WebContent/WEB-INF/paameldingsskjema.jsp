<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
	
	<link rel="stylesheet" href="hovercss.css">
<title>Påmelding</title>
</head>
<body>
	<h2>Påmelding</h2>
	<h3>Meld deg på under for å delta på tidenes fest!</h3>
	<form method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input id="inputFornavn"
					type="text" name="fornavn" value="${Skjema.fornavn}" /> <font id="feilFornavn"
					color="red">${Skjema.fornavnFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input id="inputEtternavn"
					type="text" name="etternavn" value="${Skjema.etternavn}" /> <font id="feilEtternavn"
					color="red">${Skjema.etternavnFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> <input id="inputMobil"
					type="text" name="mobil" value="${Skjema.mobil}" /> <font id="feilMobil"
					color="red">${Skjema.mobilFeil}</font>
			</div>
		
			<div class="pure-control-group">
				<div class ="tooltip"><label for="passord">Passord:
				<span class="tooltiptext">
				Passord er minst 6 tegn, <br>hvor bokstaver og tall er tillat. </span>
						</label></div><input type="password"
					name="passord" id="inputPassord" value="${Skjema.passord}" /> 
					<font color="red" >${Skjema.passordFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> <input
					id="inputPassordRepetert" type="password" name="passordRepetert"
					value="" /> <font id="feilPassordRepetert" color="red">${Skjema.passordRepFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="kjonn">Kjønn:</label> <input type="radio" name="kjonn"
					value="mann" ${Skjema.mann} />mann <input type="radio"
					name="kjonn" value="kvinne" ${Skjema.kvinne} />kvinne <font
					color="red">${Skjema.kjonnFeil}</font>
			</div>
			<div class="pure-controls">
				<button type="submit" id="button" class="pure-button pure-button-primary">Meld
					meg på</button>
			</div>
			
			


		</fieldset>
	</form>
	<p>Allerede påmeldt? <a href="Login">Trykk her.</a></p>
	<script type="text/javascript" charset="ISO-8859-1" src="validator.js"
		defer></script>
		



</body>
</html>