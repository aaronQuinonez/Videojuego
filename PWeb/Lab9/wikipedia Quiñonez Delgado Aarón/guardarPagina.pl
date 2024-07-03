#!"C:/xampp/perl/bin/perl.exe"
use strict;
use warnings;
use CGI;
use File::Path qw(make_path);

my $cgi = CGI->new;

my $titulo = $cgi->param('pageTitle');
my $texto = $cgi->param('pageContent');


my $dir = "paginas";
unless (-d $dir) {
    make_path($dir) or die "No se pudo crear el directorio: $!";
}
my $filename = "$dir/$titulo.md";
open my $fh, '>', $filename or die "No se pudo abrir el archivo: $!";
print $fh $texto;
close $fh;
print $cgi->header(-location => 'list.pl');