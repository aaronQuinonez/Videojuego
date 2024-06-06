#!"C:/xampp/perl/bin/perl.exe"
use strict;
use warnings;
use CGI;
use Text::CSV;

my $cgi = CGI->new;
my $campo = $cgi->param('opciones');
my $busqueda = uc($cgi->param('Consulta'));

print $cgi->header();
my $archivoCSV = 'Programa de Universidades.csv';

my $csv = Text::CSV->new({binary=>1, auto_diag=>1, sep_char=>'|'});
open my $fh, '<', $archivoCSV or die "No se puede abrir el archivo CSV: $archivoCSV";

my $header = $csv->getline($fh);

my @resultados;
while(my $fila = $csv->getline($fh)){
    my %datos;
    @datos{@$header} = @$fila;
    if (uc($datos{'Nombre Universidad'}) eq $busqueda && $campo eq 'Nombre Universidad'
        || uc($datos{'Periodo Licenciamiento'}) eq $busqueda && $campo eq 'Periodo Licenciamiento'
        || uc($datos{'Departamento Local'}) eq $busqueda && $campo eq 'Departamento Local'
        || uc($datos{'Denominación Programa'}) eq $busqueda && $campo eq 'Denominación Programa') {
        push @resultados, \%datos;
    }
}

close $fh;

print <<HTML;
<!DOCTYPE HTML>
<html>
<head>
    <title>Resultado de la Consulta</title>
</head>
<body>
    <div>
        <h1>Resultado de la Consulta</h1>
    </div>
    <div class="resultado">
        <table border="1">
            <tr>
                <th >Nombre de Universidad</th>
                <th >Periodo de Licenciamiento</th>
                <th >Departamento Local</th>
                <th >Denominacion Programa</th>
            </tr>
HTML

foreach my $result (@resultados) {
    print "<tr id ='otrasfila'>";
    print "<td class='columna'>$result->{'NOMBRE'}</td>";
    print "<td class='columna'>$result->{'PERIODO_LICENCIAMIENTO'}</td>";
    print "<td class='columna'>$result->{'DEPARTAMENTO_LOCAL'}</td>";
    print "<td class='ultimac'>$result->{'DENOMINACION_PROGRAMA'}</td>";
    print "</tr>";
}
