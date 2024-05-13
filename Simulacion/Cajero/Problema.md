## Problema

Se cuenta con la siguiente informacion de un cajero ATM:


|Evento  |Duración   |f  |Probabilidad   |P. Acumulada   |Intervalos |
|--------|-----------|---|---------------|---------------|-----------|
|Consulta|80 seg.    |50 |0.25           |0.25           |0 - 0.25	 |
|Otros   |50 seg.    |50 |0.25           |0.5            |0.25 - 0.5 |
|Retiros |120 seg.   |70 |0.35           |0.85           |0.5 - 0.85 |
|Trans.  |60 seg.    |30 |0.15           |1              |0.85 - 1 	 |
|TOTAL   |           |200|1.00           |               |           |


(promedio de 30 clientes/hora)

|Usuario|#ran|Tll |Mll       |Ti|T. Espera|#ran2|Op.|To|T. termina|
|-------|----|----|----------|--|---------|-----|---|--|----------|
|2      |0.18|0.40|Mllant+Tll|  |         |     |   |  |          |

Tll = (-LN(1-R)/30)*60

x = (-log(1-u) / 30) * 60
