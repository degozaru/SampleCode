.global _isNumber
_isNumber:
pushl     %ebp
movl      %esp, %ebp
xorl      %eax, %eax
movl      8(%ebp), %ebx
cmp       $9  , %ebx
jg        done
cmp       $0  , %ebx
jl        done
inc       %eax

done:
movl      %ebp, %esp
popl      %ebp
ret

.global _compare
_compare:
pushl     %ebp
movl      %esp, %ebp
xorl      %eax, %eax
movl      8(%ebp), %ebx
movl      16(%ebp), %edx
cmp       (%ebx), %edx
jg        bGreater
jl        aGreater
je        done

bGreater:
dec       %eax
jmp       done

aGreater:
inc       %eax

done:
movl      %ebp, %esp
popl      %ebp
ret

.global _countOnes
_countOnes:

