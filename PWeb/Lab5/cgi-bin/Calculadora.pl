#!"C:\xampp\perl\bin\perl.exe"
use strict;
use warnings;
use CGI qw(:standard);

print header();
print start_html("Resultado");
my $num1 = param('num1');
my $num2 = param('num2');
my $op = param('operador');

my $operacion = "$num1 $op $num2";

if ($operacion) {
    if ($operacion =~ /^\s*(\d+)\s*([\+\-])\s*(\d+)\s*$/) {
        my $num1 = $1;
        my $operador = $2;
        my $num2 = $3;
        my $resultado;

        if ($operador eq '+') {
            $resultado = $num1 + $num2;
        }

        print h2("Resultado: $num1 $operador $num2 = $resultado");
    }
}
print end_html();