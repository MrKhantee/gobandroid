package org.ligi.gobandroid_hd.logic.cell_gatherer

import org.ligi.gobandroid_hd.logic.StatefulGoBoard
import org.ligi.gobandroid_hd.logic.StatelessBoardCell

class AreaCellGatherer(board: StatefulGoBoard, root: StatelessBoardCell) : CellGatherer(board, root) {

    override fun process(cell: StatelessBoardCell) {
        val unProcessed = processed.add(cell)

        if (board.areCellsTogetherInArea(root, cell)) {
            gatheredCells.add(cell)
            if (unProcessed) {
                processNeighbors(cell)
            }
        } else if (board.isCellFree(cell) && unProcessed) {
            processNeighbors(cell)
        }
    }


}
