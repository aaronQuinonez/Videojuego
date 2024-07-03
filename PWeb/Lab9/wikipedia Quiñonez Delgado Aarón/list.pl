#!"C:/xampp/perl/bin/perl.exe"
use strict;
use warnings;
use CGI;

my $cgi = CGI->new;

print $cgi->header;
print $cgi->start_html('Nuestras paginas de Wiki');
print<<HTML;
<h1>Nuestras paginas de Wiki</h1>
<a href="listado.html">Ver Listado de Páginas</a><br><br>

<!-- Botón para crear nueva página -->
<a href="nuevaPagina.html">Nueva Pagina</a>
<a href="index.html">Volver a inicio</a>
HTML

print $cgi->end_html;