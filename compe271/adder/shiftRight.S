.global _shiftRight
_shiftRight:
pushl   %ebp
movl    %esp, %ebp
movl    8(%ebp), %esi
movl    12(%ebp), %ebx
movl    $255, %ecx

shift:
cmp     $0 , %ebx
jl      fill
movb    (%esi,%ebx,1), %al
movb    %al, (%esi,%ecx,1)
dec     %ecx
dec     %ebx
jmp     shift

fill:
cmp     $0 , %ecx
jl      doneShift
movb    $48, (%esi,%ecx,1)
dec     %ecx
jmp     fill

doneShift:
leave
ret
