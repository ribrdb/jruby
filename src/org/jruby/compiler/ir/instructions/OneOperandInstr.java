package org.jruby.compiler.ir.instructions;

import java.util.Map;

import org.jruby.compiler.ir.Operation;
import org.jruby.compiler.ir.operands.Operand;
import org.jruby.compiler.ir.operands.Variable;
import org.jruby.compiler.ir.representations.InlinerInfo;

// This is of the form:
//   v = OP(arg, attribute_array); Ex: v = NOT(v1)

public class OneOperandInstr extends IR_Instr
{
    Operand _arg;

    public OneOperandInstr(Operation op, Variable dest, Operand arg) {
        super(op, dest);
        _arg = arg;
    }

    public String toString() { return super.toString() + "(" + _arg + ")"; }

    public Operand getArg() {
        return _arg;
    }

    public Operand[] getOperands() {
        return new Operand[] {_arg};
    }

    public void simplifyOperands(Map<Operand, Operand> valueMap) {
        _arg = _arg.getSimplifiedOperand(valueMap);
    }

    public IR_Instr cloneForInlining(InlinerInfo ii) {
        return new OneOperandInstr(_op, ii.getRenamedVariable(_result), _arg.cloneForInlining(ii));
    }
}
